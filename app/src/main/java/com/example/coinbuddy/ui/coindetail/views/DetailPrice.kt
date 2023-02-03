package com.example.coinbuddy.ui.coindetail.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.coinbuddy.ui.coindetail.CoinDetailViewModel
import com.example.coinbuddy.util.toDecimalsUnits

@Composable
fun DetailPrice(state: CoinDetailViewModel.CoinDetailState) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Price Change",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )
        Row(
            modifier = Modifier.fillMaxWidth().wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .padding(4.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = "Last Hour",
                        style = typography.subtitle2,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                    )
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = state.coin?.priceChange1h.toString(),
                        style = typography.subtitle2,
                        modifier = Modifier
                    )
                }
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = "Last Day",
                        style = typography.subtitle2,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                    )
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = state.coin?.priceChange1d.toString(),
                        style = typography.subtitle2,
                        modifier = Modifier
                    )
                }
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = "Last Week",
                        style = typography.subtitle2,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                    )
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = state.coin?.priceChange1w.toString(),
                        style = typography.subtitle2,
                        modifier = Modifier
                    )
                }
            }

            Box(modifier = Modifier.width(1.dp)) {
                Divider(modifier = Modifier.height(80.dp), color = Color.DarkGray)
            }

            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .padding(4.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = "Market Cap",
                        style = typography.subtitle2,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                    )
                    Spacer(Modifier.weight(1f))
                    state.coin?.marketCap?.toDecimalsUnits()?.let {
                        Text(
                            text = it,
                            style = typography.subtitle2,
                            modifier = Modifier
                        )
                    }
                }
                Row(horizontalArrangement = Arrangement.SpaceAround) {
                    Text(
                        text = "Available",
                        style = typography.subtitle2,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                    )
                    Spacer(Modifier.weight(1f))
                    state.coin?.availableSupply?.let {
                        Text(
                            text = it.toDecimalsUnits(),
                            style = typography.subtitle2,
                            modifier = Modifier
                        )
                    }
                }
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = "Total",
                        style = typography.subtitle2,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                    )
                    Spacer(Modifier.weight(1f))
                    state.coin?.totalSupply?.let {
                        Text(
                            text = it.toDecimalsUnits(),
                            style = typography.subtitle2,
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}