package com.example.coinbuddy.ui.coindetail

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.coinbuddy.data.WatchedCoin
import com.example.coinbuddy.navigation.Screens
import com.example.coinbuddy.ui.coindetail.views.CoinChart
import com.example.coinbuddy.ui.coindetail.views.DetailButton
import com.example.coinbuddy.ui.coindetail.views.DetailHeader
import com.example.coinbuddy.ui.coindetail.views.DetailPrice

@Composable
fun CoinDetailComposable(
    viewModel: CoinDetailViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        DetailHeader(state = state)

        state.coin?.priceChange1d?.let {
            CoinChart(
                state = state,
                change = it
            )
        }

        DetailPrice(state = state)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DetailButton(
                modifier = Modifier.weight(1f),
                icon = Icons.Default.List,
                onClick = {
                    uriHandler.openUri(state.coin?.websiteUrl!!)
                }
            )
            DetailButton(
                modifier = Modifier.weight(1f),
                icon = Icons.Default.Favorite,
                onClick = {
                    viewModel.addWatchedCoin(
                        WatchedCoin(
                            id = state.coin?.id!!,
                            icon = state.coin.icon!!,
                            name = state.coin.name!!
                        )
                    )
                }
            )
            DetailButton(
                modifier = Modifier.weight(1f),
                icon = Icons.Default.Delete,
                onClick = {
                    viewModel.deleteWatchedCoin(
                        WatchedCoin(
                            id = state.coin?.id!!,
                            icon = state.coin.icon!!,
                            name = state.coin.name!!
                        )
                    )
                    navController.navigate(Screens.CoinList.route)
                }
            )
        }
    }
}