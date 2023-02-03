package com.example.coinbuddy.api.models

import com.squareup.moshi.Json

data class CoinDetailResponse(
    @Json(name = "availableSupply")
    val availableSupply: Double? = 0.0,
    @Json(name = "icon")
    val icon: String? = "",
    @Json(name = "id")
    val id: String? = "",
    @Json(name = "marketCap")
    val marketCap: Double? = 0.0,
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "price")
    val price: Double? = 0.0,
    @Json(name = "priceChange1d")
    val priceChange1d: Double? = 0.0,
    @Json(name = "priceChange1h")
    val priceChange1h: Double? = 0.0,
    @Json(name = "priceChange1w")
    val priceChange1w: Double? = 0.0,
    @Json(name = "rank")
    val rank: Int? = 0,
    @Json(name = "symbol")
    val symbol: String? = "",
    @Json(name = "totalSupply")
    val totalSupply: Double? = 0.0,
    @Json(name = "volume")
    val volume: Double? = 0.0,
    @Json(name = "websiteUrl")
    val websiteUrl: String? = "",
    @Json(name = "priceBtc")
    val priceBtc: Double? = 0.0,
)
