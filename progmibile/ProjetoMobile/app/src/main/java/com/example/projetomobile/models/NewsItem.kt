package com.example.projetomobile.models

data class NewsItem(
    val title: String,
    val date: String,
    val image_url: String,
    val description: String,
    var isExpanded: Boolean = false
)