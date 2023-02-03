package com.example.coinbuddy.api.repository

import com.example.coinbuddy.api.ChartDto
import com.example.coinbuddy.api.CoinItemDto
import com.example.coinbuddy.api.CoinsDto

interface CoinRepository {

    // api requests
    suspend fun getCoins(): CoinsDto

    suspend fun getCoinById(coinId: String): CoinItemDto

    suspend fun getChartsData(coinId: String): ChartDto
}
