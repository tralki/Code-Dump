package com.example.projetomobile.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetomobile.R
import com.example.projetomobile.adapters.AssetAdapter
import com.example.projetomobile.adapters.AssetClickListener
import com.example.projetomobile.models.Asset
import com.example.projetomobile.models.SearchViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import com.example.projetomobile.api.PreferencesManager

class SearchFragment : Fragment(), AssetClickListener {

    private lateinit var searchViewModel: SearchViewModel
    private lateinit var searchResultsRecyclerView: RecyclerView
    private lateinit var assetAdapter: AssetAdapter
    private lateinit var searchView: androidx.appcompat.widget.SearchView

    private val selectedAssets = mutableListOf<Asset>()
    private var searchJob: Job? = null

    private val preferencesManager: com.example.projetomobile.preferences.PreferencesManager by lazy {
        com.example.projetomobile.preferences.PreferencesManager(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("SearchFragment", "onCreateView")
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        searchResultsRecyclerView = view.findViewById(R.id.searchResultsRecyclerView)

        assetAdapter = AssetAdapter(LayoutInflater.from(requireContext()), this::onAssetClicked, preferencesManager, this)
        searchResultsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        searchResultsRecyclerView.adapter = assetAdapter

        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            searchViewModel.observeNonMonitoredAssets { nonMonitoredAssets ->
                Log.d("SearchFragment", "Non-Monitored Assets: $nonMonitoredAssets")
                assetAdapter.updateData(nonMonitoredAssets)
            }

            searchViewModel.searchResults.onEach { searchResults ->
                Log.d("SearchFragment", "Search Results: $searchResults")
                if (searchResults.isEmpty()) {
                    assetAdapter.updateData(searchViewModel.nonMonitoredAssets.value)
                } else {
                    assetAdapter.updateData(searchResults)
                }
            }.collect()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            searchViewModel.nonMonitoredAssets.collect { nonMonitoredAssets ->
                assetAdapter.updateData(nonMonitoredAssets)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            searchViewModel.selectedAssets.collect { selectedAssets ->
                // Atualize a UI conforme necessário com os ativos selecionados
                // por exemplo, atualize o estado dos itens no RecyclerView
                assetAdapter.updateSelectedAssets(selectedAssets)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            searchViewModel.addButtonVisibility.collect { isVisible ->
                val addButton = view?.findViewById<Button>(R.id.addButton)
                addButton?.visibility = if (isVisible) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }
        }

        val clearButton = view.findViewById<Button>(R.id.clearButton)
        clearButton.setOnClickListener {
            onClearSelectedAssetsClicked()
        }

        searchView = view.findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("SearchFragment", "onQueryTextSubmit: $query")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("SearchFragment", "onQueryTextChange: $newText")
                if (!newText.isNullOrBlank()) {
                    searchJob?.cancel()
                    searchJob = viewLifecycleOwner.lifecycleScope.launch {
                        delay(300)
                        performSearch(newText)
                    }
                } else {
                    searchViewModel.getAllNonMonitoredAssets()
                }
                return true
            }
        })

        val addButton = view.findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            onAddSelectedAssetsButtonClicked()
        }
        updateAddButtonVisibility()

        return view
    }
    private fun performSearch(query: String) {
        Log.d("SearchFragment", "performSearch: $query")

        if (query.isNotBlank()) {
            searchViewModel.searchAssets(query)
        } else {
            searchViewModel.getAllNonMonitoredAssets()
        }
    }

    override fun onAssetClicked(asset: Asset) {
        Log.d("SearchFragment", "onAssetClicked: $asset")
        if (selectedAssets.contains(asset)) {
            selectedAssets.remove(asset)
        } else {
            selectedAssets.add(asset)
        }
        updateAddButtonVisibility()
        assetAdapter.toggleExpandedState(asset)

        // Atualize o estado do ViewModel
        searchViewModel.onAssetClicked(asset)
    }

    private fun onClearSelectedAssetsClicked() {
        selectedAssets.clear()
        updateAddButtonVisibility()
    }

    private fun updateAddButtonVisibility() {
        val addButton = view?.findViewById<Button>(R.id.addButton)
        addButton?.visibility = if (selectedAssets.isNotEmpty()) {
            Log.d("SearchFragment", "Update Add Button Visibility: Visible")
            View.VISIBLE
        } else {
            Log.d("SearchFragment", "Update Add Button Visibility: Gone")
            View.GONE
        }
    }

    private fun addSelectedAssetsToMonitoredList() {
        selectedAssets.forEach { selectedAsset ->
            searchViewModel.moveAssetToMonitored(selectedAsset)
        }

        selectedAssets.clear()

        preferencesManager.clearSelectedAssets()

        Toast.makeText(requireContext(), "Ativos adicionados aos monitorizados", Toast.LENGTH_SHORT).show()
    }

    private fun onAddSelectedAssetsButtonClicked() {
        searchViewModel.addSelectedAssetsToMonitoredList()
    }
}