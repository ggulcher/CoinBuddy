package com.example.coinbuddy.ui.coinwatch

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinbuddy.api.models.CoinDetailResponse
import com.example.coinbuddy.data.FirebaseRepository
import com.example.coinbuddy.data.WatchedCoin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinWatchViewModel @Inject constructor(
    private val firebaseRepository: FirebaseRepository
) : ViewModel() {

    var state by mutableStateOf(CoinWatchState())

    init {
        getWatchedCoins()
    }

    private fun getWatchedCoins() {
        viewModelScope.launch {
            firebaseRepository.getWatchedCoins().let { result ->
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