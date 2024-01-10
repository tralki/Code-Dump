package com.example.projetomobile.api

import com.example.projetomobile.models.NewsItem
import com.example.projetomobile.models.Asset
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/api/symbols")
    suspend fun getStockSymbols(): List<String>

    @GET("/api/symbol/summary/{symbol}")
    suspend fun getStockSummary(@Path("symbol") symbol: String): Asset

    @GET("/api/symbol/details/{symbol}")
    suspend fun getStockDetails(@Path("symbol") symbol: String): Asset

    @GET("/api/news")
    suspend fun getFinancialNews(): List<NewsItem>

    @GET("/api/symbol/search/{query}")
    suspend fun searchStocks(@Path("query") query: String): List<Asset>

    companion object {
        private const val BASE_URL = "https://tuxdroid.pythonanywhere.com/"

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }

    // Exemplo de método para obter ativos não monitorados
    @GET("assets/nonMonitored")
    suspend fun getNonMonitoredAssets(): List<Asset>

    // Exemplo de método para realizar a pesquisa de ativos
    @GET("assets/search")
    suspend fun searchAssets(@Query("query") query: String): List<Asset>
}