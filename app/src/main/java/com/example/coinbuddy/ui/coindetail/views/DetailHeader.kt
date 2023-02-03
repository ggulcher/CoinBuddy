package com.example.coinbuddy.ui.coindetail.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.coinbuddy.api.models.CoinResponse
import com.example.coinbuddy.ui.coindetail.CoinDetailViewModel
import com.example.coinbuddy.util.toDecimalsUnits

@Composable
fun DetailHeader(state: CoinDetailViewModel.CoinDetailState) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column() {
            Text(
                text = state.coin?.name ?: "",
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Start
            )
            Text(
                text = "$" + state.coin?.price?.toDecimalsUnits(),
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Text(
            text = state.coin?.priceChange1d.toString() + "%",
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}