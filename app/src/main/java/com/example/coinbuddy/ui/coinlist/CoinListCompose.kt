package com.example.coinbuddy.ui.coinlist

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.coinbuddy.navigation.Screens
import com.example.coinbuddy.ui.coinlist.views.CoinListRow
import com.example.coinbuddy.ui.coinlist.views.SearchBar
import com.example.coinbuddy.ui.coinlist.views.TopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CoinListComposable(
    viewModel: CoinListViewModel = hiltViewModel(),
    navController: NavController
) {
    val scaffoldState = rememberScaffoldState()
    val searchState = remember { mutableStateOf(TextFieldValue("")) }
    val lazyListState = rememberLazyListState()
    val state = viewModel.state

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                title = "CoinBuddy",
                onClick = {
                    navController.navigate(
                        Screens.CoinWatch.route
                    )
                }
            )
        },
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                SearchBar(
                    hint = "...",
                    modifier = Modifier.fillMaxWidth(),
                    state = searchState
                )
                val isBeingSearched = searchState.value.text
                LazyColumn(
                    state = lazyListState,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(items = state.coins.filter {
                        it.name!!.contains(isBeingSearched, ignoreCase = true) ||
                                it.id!!.contains(isBeingSearched, ignoreCase = true) ||
                                it.symbol!!.contains(isBeingSearched, ignoreCase = true)
                    }, key = { it.id!! }) { coins ->
                        CoinListRow(
                            coin = coins,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}
