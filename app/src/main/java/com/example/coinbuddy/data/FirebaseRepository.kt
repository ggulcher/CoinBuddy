package com.example.coinbuddy.data

import com.example.coinbuddy.util.Resource
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface FirebaseRepository {

    suspend fun addWatchedCoin(coin: WatchedCoin)

    suspend fun deleteWatchedCoin(coin: WatchedCoin)

//    fun isFavorite(coinById: CoinById): Flow<CoinById?>

    suspend fun getWatchedCoins(): List<WatchedCoin>
}