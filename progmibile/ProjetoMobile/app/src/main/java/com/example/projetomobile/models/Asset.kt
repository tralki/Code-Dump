package com.example.projetomobile.models

import com.google.gson.annotations.SerializedName

data class Asset(
    @SerializedName("symbol")
    val symbol: String,

    @SerializedName("current_price")
    val currentPrice: Double,

    @SerializedName("change_percent")
    val percentChange: Double,

    @SerializedName("logo_url")
    val logoUrl: String,

    @SerializedName("CEO")
    val ceo: String,

    @SerializedName("chart_data")
    val chartData: Map<String, List<Double>>,

    @SerializedName("description")
    val description: String,

    @SerializedName("sector")
    val sector: String,

    var isExpanded: Boolean = false,
    var isSelected: Boolean = false,
    var isMonitored: Boolean
)