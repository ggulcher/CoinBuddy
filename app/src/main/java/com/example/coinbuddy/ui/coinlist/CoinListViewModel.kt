package com.example.coinbuddy.ui.coinlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinbuddy.api.models.CoinResponse
import com.example.coinbuddy.api.repository.CoinRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val repository: CoinRepositoryImpl,
) : ViewModel() {

    var state by mutableStateOf(CoinState())

    init {
        getCoinsList()
    }

    private fun getCoinsList() {
        viewModelScope.launch {
            repository.getCoins().let { result ->
                state = state.copy(coins = result.coins)
            }
        }
    }

    data class CoinState(
        val coins: List<CoinResponse> = emptyList(),
        val isLoading: Boolean = false,
        val error: String = ""
    )
}
