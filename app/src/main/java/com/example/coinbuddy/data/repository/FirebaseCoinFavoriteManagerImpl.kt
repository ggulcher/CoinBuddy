package com.example.coinbuddy.data.repository

import com.example.coinbuddy.data.models.WatchedCoin
import com.example.coinbuddy.util.Constants.FIREBASE_COLLECTION
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import timber.log.Timber

class FirebaseCoinFavoriteManagerImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : FirebaseCoinFavoriteManager {

    private val watchedCoinRef = firestore.collection(FIREBASE_COLLECTION)

    override suspend fun addWatchedCoin(coin: WatchedCoin) {
        val query = watchedCoinRef
            .whereEqualTo("id", coin.id)
            .get()
            .await()

        if (query.isEmpty) {
            try {
                watchedCoinRef.add(coin)
            } catch (e: Exception) {
                withContext(Dispatchers.Main) { Timber.e(e) }
            }
        }
    }

    override suspend fun deleteWatchedCoin(coin: WatchedCoin) {
        val query = watchedCoinRef
            .whereEqualTo("id", coin.id)
            .get()
            .await()

        if (query.documents.isNotEmpty()) {
            for (document in query) {
                try {
                    watchedCoinRef.document(document.id).delete().await()
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) { Timber.e(e) }
                }
            }
        }
    }

    override suspend fun getWatchedCoins(): List<WatchedCoin> {
        val watchedCoins = ArrayList<WatchedCoin>()
        watchedCoinRef.get().await().let {
            for (document in it) {
                watchedCoins.add(document.toObject(WatchedCoin::class.java))
            }
        }
        return watchedCoins.toList()
    }
}
