package com.example.coinbuddy.ui.coinwatch

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.coinbuddy.data.WatchedCoin
import com.example.coinbuddy.navigation.Screens

@Composable
fun CoinWatchComposable(
    navController: NavController,
    viewModel: CoinWatchViewModel = hiltViewModel()
) {

    val lazyListState = rememberLazyGridState()
    val state = viewModel.state

    Text(text = state.watchList?.size.toString())

    LazyVerticalGrid(
        modifier = Modifier.padding(vertical = 8.dp),
        state = lazyListState,
        content = {
            items(items = state.watchList ?: emptyList()) { item ->
                WatchItem(item = item, navController = navController)
            }
        },
        columns = GridCells.Adaptive(minSize = 128.dp)
    )
}

@Composable
fun WatchItem(
    item: WatchedCoin,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .aspectRatio(1f)
            .border(
                border = ButtonDefaults.outlinedBorder,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {
                navController.navigate(
                    Screens.CoinDetail.route + "/${item.id}"
                )
            }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = item.icon,
                contentDescription = "Icon",
                modifier = Modifier.size(50.dp)
            )
            Text(
                text = item.name,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Start
            )
        }
    }
}
