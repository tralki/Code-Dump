// MonitoradosFragment.kt
package com.example.projetomobile.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetomobile.R
import com.example.projetomobile.adapters.AssetAdapter
import com.example.projetomobile.models.Asset
import com.example.projetomobile.models.SearchViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.projetomobile.adapters.AssetClickListener
import kotlinx.coroutines.flow.collect
import com.example.projetomobile.preferences.PreferencesManager
import kotlinx.coroutines.launch

class MonitoradosFragment : Fragment(), AssetClickListener {

    private lateinit var searchViewModel: SearchViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var assetAdapter: AssetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicialize o ViewModel usando ViewModelProvider
        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_monitorados, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Criando uma instância de PreferencesManager
        val preferencesManager = PreferencesManager(requireContext())

        // Configurando o AssetAdapter com PreferencesManager
        assetAdapter = AssetAdapter(
            LayoutInflater.from(requireContext()),
            this::onAssetClicked,
            preferencesManager,
            this
        )
        recyclerView.adapter = assetAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Certify that the ViewModel is initialized
        if (::searchViewModel.isInitialized) {
            // Use repeatOnLifecycle to observe changes in monitored assets
            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    searchViewModel.monitoredAssetsChanged.collect {
                        // Update the RecyclerView or perform any necessary logic
                        updateMonitoredAssets()
                    }
                }
            }
        }

        // Call the method to get monitored assets
        updateMonitoredAssets()
    }

    override fun onAssetClicked(asset: Asset) {
        assetAdapter.toggleExpandedState(asset)
    }


    override fun onResume() {
        super.onResume()

        // Certifique-se de que a RecyclerView está visível
        recyclerView.visibility = View.VISIBLE

        // Chame o método para obter os ativos monitorados
        updateMonitoredAssets()
    }

    private fun updateMonitoredAssets() {
        val monitoredAssets = searchViewModel.getMonitoredAssets()
        Log.d("MonitoradosFragment", "Monitored Assets: $monitoredAssets")
        assetAdapter.updateData(monitoredAssets)
    }

}