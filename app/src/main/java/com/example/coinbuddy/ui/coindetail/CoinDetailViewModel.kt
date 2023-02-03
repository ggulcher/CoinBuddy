package com.example.coinbuddy.ui.coindetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinbuddy.api.models.CoinDetailResponse
import com.example.coinbuddy.api.repository.CoinRepositoryImpl
import com.example.coinbuddy.data.FirebaseRepository
import com.example.coinbuddy.data.WatchedCoin
import com.example.coinbuddy.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val repository: CoinRepositoryImpl,
    private val firebaseRepository: FirebaseRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(CoinDetailState())

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoinItem(coinId)
            getCoinChart(coinId)
        }
    }

    private fun getCoinItem(id: String) {
        viewModelScope.launch {
            repository.getCoinById(id).let { result ->
                state = state.copy(coin = result.coin)
            }
        }
    }

    private fun getCoinChart(id: String) {
        viewModelScope.launch {
            repository.getChartsData(id).let {result ->
                state = state.copy(chart = result.chart)
            }
        }
    }

    fun onWatchButtonClicked(coin: WatchedCoin, isWatched: Boolean) {
        when {
            isWatched -> addWatchedCoin(coin)
            else -> deleteWatchedCoin(coin)
        }
    }

    fun addWatchedCoin(coin: WatchedCoin) {
        viewModelScope.launch {
            firebaseRepository.addWatchedCoin(coin)
        }
    }

    fun deleteWatchedCoin(coin: WatchedCoin) {
        viewModelScope.launch {
            firebaseRepository.deleteWatchedCoin(coin)
        }
    }

    private fun getMarketChange(id: String) {
        viewModelScope.launch {
            repository.getCoinById(id)
        }
    }

    data class CoinDetailState(
        val coin: CoinDetailResponse ?= null,
        val chart: List<List<Float>> ?= emptyList(),
        val isLoading: Boolean = false,
        val error: String = ""
    )
}