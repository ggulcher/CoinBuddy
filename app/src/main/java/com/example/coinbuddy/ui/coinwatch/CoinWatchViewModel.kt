package com.example.coinbuddy.ui.coinwatch

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinbuddy.data.repository.FirebaseCoinFavoriteManager
import com.example.coinbuddy.data.models.WatchedCoin
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class CoinWatchViewModel @Inject constructor(
    private val firebaseCoinFavoriteManager: FirebaseCoinFavoriteManager
) : ViewModel() {

    var state by mutableStateOf(CoinWatchState())

    init {
        getWatchedCoins()
    }

    private fun getWatchedCoins() {
        viewModelScope.launch {
            firebaseCoinFavoriteManager.getWatchedCoins().let { result ->
                state = state.copy(watchList = result)
            }
        }
    }

    data class CoinWatchState(
        val watchList: List<WatchedCoin>? = emptyList(),
        val isLoading: Boolean = false,
        val error: String = ""
    )
}
