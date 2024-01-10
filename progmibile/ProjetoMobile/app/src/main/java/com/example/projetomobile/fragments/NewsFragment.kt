package com.example.projetomobile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetomobile.R
import com.example.projetomobile.adapters.NewsAdapter
import com.example.projetomobile.api.ApiService
import com.example.projetomobile.models.NewsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// NewsFragment.kt
class NewsFragment : Fragment() {

    private lateinit var recyclerViewNews: RecyclerView
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)

        recyclerViewNews = view.findViewById(R.id.recyclerViewNews)
        recyclerViewNews.layoutManager = LinearLayoutManager(requireContext())
        newsAdapter = NewsAdapter { position -> onNewsClicked(position) }
        recyclerViewNews.adapter = newsAdapter

        return view
    }

    override fun onResume() {
        super.onResume()
        // Iniciar a chamada à API apenas quando a guia de notícias estiver visível
        fetchNewsData()
    }

    private fun fetchNewsData() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val apiService = ApiService.create()
                val newsList = apiService.getFinancialNews()

                withContext(Dispatchers.Main) {
                    // Log das URLs das imagens
                    newsList.forEach {
                        println("Image URL for title ${it.title}: ${it.image_url}")
                    }

                    // Atualize o adaptador com a lista de notícias recebida
                    val updatedList = newsList.map {
                        NewsItem(
                            title = it.title ?: "",
                            date = it.date ?: "",
                            image_url = it.image_url ?: run {
                                println("Image URL is null for title: ${it.title}")
                                ""
                            },
                            description = it.description ?: ""
                        )
                    }
                    newsAdapter.updateNewsList(updatedList)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    println("API Response: ERRO AO OBTER NOTICIAS")
                    println("Error: ${e.message}")
                    e.printStackTrace()
                }
            }
        }
    }

    fun refreshData() {
        // Chame o método fetchNewsData() ao atualizar os dados
        fetchNewsData()
    }

    private fun onNewsClicked(position: Int) {
        newsAdapter.toggleExpansion(position)
    }
}