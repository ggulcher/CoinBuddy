package com.example.coinbuddy.ui.coinlist.views

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.coinbuddy.api.models.CoinResponse
import com.example.coinbuddy.navigation.Screens
import com.example.coinbuddy.ui.theme.performanceGreen
import com.example.coinbuddy.ui.theme.performanceRed
import com.example.coinbuddy.util.toDecimalsUnits

@Composable
fun CoinListRow(
    coin: CoinResponse,
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                border = ButtonDefaults.outlinedBorder,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {
                navController.navigate(
                    Screens.CoinDetail.route + "/${coin.id}"
                )
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(50.dp)
        ) {
            AsyncImage(
                model = coin.icon ,
                contentDescription = "Icon",
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.Center)
            )
        }

        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = coin.name ?: "",
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.size(2.dp))

                Text(
                    text = coin.symbol.toString(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier
                )
            }
            coin.marketCap?.toDecimalsUnits()?.let {
                Text(
                    text = it,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            Text(
                text = "$" + coin.price?.toDecimalsUnits(),
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = coin.priceChange1d.toString() + "%",
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Bold,
                color = if (coin.priceChange1d!! < 0) {
                    MaterialTheme.colors.performanceRed
                } else MaterialTheme.colors.performanceGreen
            )
        }
    }
}
