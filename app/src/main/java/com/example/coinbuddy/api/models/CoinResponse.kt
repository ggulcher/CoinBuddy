package com.example.coinbuddy.api.models

import com.squareup.moshi.Json

data class CoinResponse(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "icon")
    val icon: String? = null,
    @Json(name = "marketCap")
    val marketCap: Double? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "price")
    val price: Double? = null,
    @Json(name = "priceChange1d")
    val priceChange1d: Double? = null,
    @Json(name = "rank")
    val rank: Int? = null,
    @Json(name = "symbol")
    val symbol: String? = null
)
