package com.example.coinbuddy.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("v1/coins")
    suspend fun getCoins(
        @Query("currency") currency: String = "USD",
        @Query("skip") skip: Int = 0
    ): CoinsDto

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(
        @Path("coinId") coinId: String
    ): CoinItemDto

    @GET("v1/charts")
    suspend fun getChartsData(
        @Query("coinId") coinId: String,
        @Query("period") period: String = "24h"
    ): ChartDto
}
