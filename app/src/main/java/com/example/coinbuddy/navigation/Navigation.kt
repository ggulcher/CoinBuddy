package com.example.coinbuddy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coinbuddy.ui.coindetail.CoinDetailComposable
import com.example.coinbuddy.ui.coinlist.CoinListComposable
import com.example.coinbuddy.ui.coinwatch.CoinWatchComposable

@Composable
fun Navigation() {

    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.CoinList.route
    ) {
        composable(
            route = Screens.CoinList.route
        ) {
            CoinListComposable(navController = navController)
        }

        composable(
            route = Screens.CoinDetail.route + "/{coinId}"
        ) {
            CoinDetailComposable(navController = navController)
        }

        composable(
            route = Screens.CoinWatch.route
        ) {
            CoinWatchComposable(
                navController = navController
            )
        }
    }
}
