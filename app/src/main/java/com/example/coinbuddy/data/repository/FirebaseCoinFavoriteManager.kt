package com.example.coinbuddy.data.repository

import com.example.coinbuddy.data.models.WatchedCoin

interface FirebaseCoinFavoriteManager {

    suspend fun addWatchedCoin(coin: WatchedCoin)

    suspend fun deleteWatchedCoin(coin: WatchedCoin)

//    fun isFavorite(coinById: CoinById): Flow<CoinById?>

    suspend fun getWatchedCoins(): List<WatchedCoin>
}
