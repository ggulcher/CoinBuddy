package com.example.coinbuddy.ui.coinwatch

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
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
import com.example.coinbuddy.data.models.WatchedCoin
import com.example.coinbuddy.navigation.Screens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CoinWatchComposable(
    navController: NavController,
    viewModel: CoinWatchViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val lazyListState = rememberLazyListState()
    val state = viewModel.state

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            Box(modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 12.dp)) {
                Text(
                    text = "Favorite Coins",
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            LazyColumn(
                modifier = Modifier.padding(vertical = 12.dp),
                state = lazyListState,
                verticalArrangement = Arrangement.spacedBy(10.dp),
                content = {
                    items(items = state.watchList ?: emptyList()) { item ->
                        WatchItem(item = item, navController = navController)
                    }
                }
            )
        }
    }
}

@Composable
fun WatchItem(
    item: WatchedCoin,
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
                    Screens.CoinDetail.route + "/${item.id}"
                )
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = item.icon,
            contentDescription = "Icon",
            modifier = Modifier
                .size(50.dp)
                .padding(12.dp)
        )
        Text(
            text = item.name,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Start
        )
    }
}
