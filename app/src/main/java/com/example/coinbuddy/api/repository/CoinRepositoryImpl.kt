package com.example.coinbuddy.api.repository

import com.example.coinbuddy.api.ApiService
import com.example.coinbuddy.api.ChartDto
import com.example.coinbuddy.api.CoinItemDto
import com.example.coinbuddy.api.CoinsDto
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: ApiService
) : CoinRepository {

    override suspend fun getCoins(): CoinsDto {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinItemDto {
        return api.getCoinById(coinId)
    }

    override suspend fun getChartsData(coinId: String): ChartDto {
        return api.getChartsData(coinId)
    }
}
