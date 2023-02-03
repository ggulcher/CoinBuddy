package com.example.coinbuddy.api

import com.example.coinbuddy.api.models.CoinDetailResponse
import com.example.coinbuddy.api.models.CoinResponse

data class CoinsDto(
    val coins: List<CoinResponse>
)

data class CoinItemDto(
    val coin: CoinDetailResponse
)

data class ChartDto(
    val chart: List<List<Float>>,
)
