package com.example.projetomobile.models

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetomobile.R
import com.example.projetomobile.api.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchViewModel(application: Application) : AndroidViewModel(application) {

    private val apiService: ApiService = ApiService.create()

    private val _nonMonitoredAssets = MutableStateFlow<List<Asset>>(emptyList())
    val nonMonitoredAssets: StateFlow<List<Asset>> get() = _nonMonitoredAssets

    private val _monitoredAssets = MutableStateFlow<List<Asset>>(emptyList())
    val monitoredAssets: StateFlow<List<Asset>> get() = _monitoredAssets

    private val _searchResults = MutableStateFlow<List<Asset>>(emptyList())
    val searchResults: StateFlow<List<Asset>> get() = _searchResults

    private val _selectedAssets = MutableStateFlow<List<Asset>>(emptyList())
    val selectedAssets: StateFlow<List<Asset>> get() = _selectedAssets

    private val _addButtonVisibility = MutableStateFlow(false)
    val addButtonVisibility: StateFlow<Boolean> get() = _addButtonVisibility

    private val _monitoredAssetsChanged = MutableSharedFlow<Unit>()
    val monitoredAssetsChanged: Flow<Unit> get() = _monitoredAssetsChanged.asSharedFlow()

    private lateinit var progressBar: ProgressBar

    init {
        fetchNonMonitoredAssets()
    }


    private fun fetchNonMonitoredAssets() {
        viewModelScope.launch {
            try {
                val symbols = apiService.getStockSymbols()

                val nonMonitoredAssets = symbols.mapNotNull { symbol ->
                    try {
                        // Utilize o endpoint de summary para obter as informações resumidas
                        val assetSummary = apiService.getStockSummary(symbol)

                        // Se assetSummary for nulo ou não contiver as informações necessárias, retorne null
                        if (assetSummary == null || assetSummary.symbol.isNullOrBlank()) {
                            Log.e("SearchViewModel", "AssetSummary is null or missing required info for symbol: $symbol")
                            return@mapNotNull null
                        }

                        val symbol = assetSummary.symbol
                        val currentPrice = assetSummary.currentPrice ?: 0.0
                        val percentChange = assetSummary.percentChange ?: 0.0
                        val logoUrl = assetSummary.logoUrl ?: ""

                        // Agora, utilize o endpoint de details para obter informações adicionais
                        val assetDetails = apiService.getStockDetails(symbol)

                        if (assetDetails == null) {
                            Log.e("SearchViewModel", "AssetDetails is null for symbol: $symbol")
                            return@mapNotNull null
                        }

                        val ceo = assetDetails.ceo ?: ""
                        val chartData = assetDetails.chartData ?: emptyMap()
                        val description = assetDetails.description ?: ""
                        val sector = assetDetails.sector ?: ""

                        Asset(
                            symbol,
                            currentPrice,
                            percentChange,
                            logoUrl,
                            ceo,
                            chartData,
                            description,
                            sector,
                            isMonitored = false
                        )
                    } catch (e: Exception) {
                        // Tratar exceções conforme necessário
                        Log.e("SearchViewModel", "Error processing asset for symbol: $symbol", e)
                        null
                    }
                }

                _nonMonitoredAssets.value = nonMonitoredAssets
                Log.d("SearchViewModel", "Non-Monitored Assets: $nonMonitoredAssets")
            } catch (e: Exception) {
                Log.e("SearchViewModel", "Error fetching non-monitored assets", e)
            }
        }
    }

    fun searchAssets(query: String) {
        if (query.isNotBlank()) {
            viewModelScope.launch {
                try {
                    val searchResults = apiService.searchStocks(query)
                    _searchResults.value = searchResults
                    Log.d("SearchViewModel", "Search Results: $searchResults")
                } catch (e: Exception) {
                    // Handle network errors or other exceptions if necessary
                    Log.e("SearchViewModel", "Error searching assets", e)
                }
            }
        }
    }

    fun addNonMonitoredAsset(asset: Asset) {
        _nonMonitoredAssets.value = (_nonMonitoredAssets.value + asset).distinct()
    }

    fun moveAssetToMonitored(asset: Asset) {
        val nonMonitoredAssetsList = _nonMonitoredAssets.value
        val newMonitoredAssets = (_monitoredAssets.value + asset).distinct()

        _monitoredAssets.value = newMonitoredAssets
        _nonMonitoredAssets.value = nonMonitoredAssetsList - asset

        // Emitir o evento de mudança
        viewModelScope.launch {
            _monitoredAssetsChanged.emit(Unit)
        }

        Log.d("SearchViewModel", "Monitored Assets: ${_monitoredAssets.value}")
    }

    fun observeNonMonitoredAssets(observer: (List<Asset>) -> Unit) {
        viewModelScope.launch {
            nonMonitoredAssets.collect {
                Log.d("SearchViewModel", "Observed Non-Monitored Assets: $it")
                observer(it)
            }
        }
    }

    fun onAssetClicked(asset: Asset) {
        _selectedAssets.value = if (selectedAssets.value.contains(asset)) {
            _selectedAssets.value.filter { it != asset }
        } else {
            _selectedAssets.value + asset
        }
        updateAddButtonVisibility()
    }

    private val _loadingState = MutableSharedFlow<Boolean>()
    val loadingState: Flow<Boolean> get() = _loadingState.asSharedFlow()

    fun getAllNonMonitoredAssets() {
        viewModelScope.launch {
            _loadingState.emit(true) // Indica que a operação está em andamento
            fetchNonMonitoredAssets()
            _loadingState.emit(false) // Indica que a operação foi concluída
        }
    }

    fun getMonitoredAssets(): List<Asset> {
        return _monitoredAssets.value
    }

    fun addSelectedAssetsToMonitoredList() {
        _selectedAssets.value.forEach { selectedAsset ->
            moveAssetToMonitored(selectedAsset)
        }

        _selectedAssets.value = emptyList() // Limpa a lista de ativos selecionados
        // Log para verificar se a função está sendo chamada
        Log.d("TESTE123MonitoradosFragment", "Assets added to monitored list")
        // Agora, você precisa implementar a lógica para atualizar a visibilidade do botão.
        // Sugiro criar uma função separada para isso.
        updateAddButtonVisibility()
    }

    fun updateAddButtonVisibility() {
        // Implemente a lógica para atualizar a visibilidade do botão aqui.
        // Por exemplo, você pode usar uma variável StateFlow<Boolean> chamada addButtonVisibility.
        // Substitua de acordo com a sua implementação real.

        // Aqui, estou assumindo que você tem uma variável StateFlow<Boolean> chamada addButtonVisibility.
        // Substitua de acordo com a sua implementação real.
        _addButtonVisibility.value = _selectedAssets.value.isNotEmpty()
    }

    override fun onCleared() {
        // Chamado quando o ViewModel está prestes a ser limpo
        super.onCleared()
    }
    fun toggleMonitoredStatus(asset: Asset, isMonitored: Boolean = true) {
        // Toggle the monitored status of the asset
        asset.isMonitored = isMonitored

        if (isMonitored) {
            moveAssetToMonitored(asset)
        } else {
            // Implement the logic to remove the asset from the monitored list if needed.
        }
    }
}