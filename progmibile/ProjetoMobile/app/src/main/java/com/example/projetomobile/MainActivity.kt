package com.example.projetomobile

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.projetomobile.adapters.AssetAdapter
import com.example.projetomobile.adapters.AssetClickListener
import com.example.projetomobile.adapters.MyFragmentStateAdapter
import com.example.projetomobile.fragments.MonitoradosFragment
import com.example.projetomobile.models.Asset
import com.example.projetomobile.models.SearchViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import com.example.projetomobile.preferences.PreferencesManager
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), AssetClickListener {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var monitoradosFragment: MonitoradosFragment
    private lateinit var searchEditText: EditText
    private lateinit var assetAdapter: AssetAdapter
    private val NEWS_TAB_POSITION = 2

    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupAddAssetButton()
        setupViewPager()
        observeMonitoredAssets()
        observeNonMonitoredAssets()
        observeSearchResults()
    }

    private fun setupViewPager() {
        val fragmentStateAdapter = MyFragmentStateAdapter(this)
        viewPager = findViewById(R.id.viewPager)
        monitoradosFragment = MonitoradosFragment()
        viewPager.adapter = fragmentStateAdapter
        tabLayout = findViewById(R.id.tabLayout)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Monitorados"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.stock)
                    Log.d("TabLayoutMediator", "Tab Position: $position")
                }
                1 -> {
                    tab.text = "Pesquisar"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.manage_search)
                }
                NEWS_TAB_POSITION -> {
                    tab.text = "Notícias"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.news)
                }
            }
        }.attach()

        setupRecyclerView()
    }

    private fun setupAddAssetButton() {
        val btnAddAsset = findViewById<View>(R.id.btnAddAsset)

        btnAddAsset.setOnClickListener {
            if (viewPager.currentItem == 0) {
                supportFragmentManager.beginTransaction().hide(monitoradosFragment).commit()
                searchEditText = findViewById(R.id.searchEditText)
                searchEditText.setOnEditorActionListener { _, _, _ ->
                    hideKeyboard()
                    true
                }

                searchEditText.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {}

                    override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                        val query = charSequence.toString()
                        filterAssets(query)
                    }

                    override fun afterTextChanged(editable: Editable?) {}
                })

                viewPager.currentItem = 1
            }
        }
    }

    private fun setupRecyclerView() {
        val recyclerView = monitoradosFragment.view?.findViewById<RecyclerView>(R.id.recyclerView)
        val preferencesManager = PreferencesManager(this)

        assetAdapter = AssetAdapter(
            LayoutInflater.from(this),
            { asset: Asset -> onAssetClicked(asset) },
            preferencesManager,
            this
        )
        assetAdapter.setOnItemClickListener { asset -> /* Handle item click if needed */ }
        recyclerView?.adapter = assetAdapter
    }

    private fun observeMonitoredAssets() {
        lifecycleScope.launchWhenStarted {
            searchViewModel.monitoredAssets.collect { monitoredAssets ->
                assetAdapter.updateData(monitoredAssets)
            }
        }
    }

    private fun observeNonMonitoredAssets() {
        lifecycleScope.launchWhenStarted {
            searchViewModel.nonMonitoredAssets.collect { nonMonitoredAssets ->
                /* Handle non-monitored assets if needed */
            }
        }
    }

    private fun observeSearchResults() {
        lifecycleScope.launchWhenStarted {
            searchViewModel.searchResults.collect { searchResults ->
                /* Handle search results if needed */
            }
        }
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(searchEditText.windowToken, 0)
    }

    private fun filterAssets(query: String) {
        lifecycleScope.launch(Dispatchers.Main) {
            searchViewModel.searchAssets(query)
        }
    }

    override fun onAssetClicked(asset: Asset) {
        if (asset.isExpanded) {
            collapseAsset(asset)
        } else {
            expandAsset(asset)
            addAssetToMonitoredList(asset)
        }
    }

    private fun expandAsset(asset: Asset) {
        asset.isExpanded = true
        assetAdapter.notifyItemChanged(assetAdapter.assets.indexOf(asset))
    }

    private fun collapseAsset(asset: Asset) {
        asset.isExpanded = false
        assetAdapter.notifyItemChanged(assetAdapter.assets.indexOf(asset))
    }

    private fun addAssetToMonitoredList(asset: Asset) {
        searchViewModel.moveAssetToMonitored(asset)
    }

    override fun onResume() {
        super.onResume()
        // Certifique-se de que a guia "Monitorados" está ativa
        viewPager.currentItem = 0 // ou a posição correta da guia "Monitorados"
    }
}