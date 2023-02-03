package com.example.coinbuddy.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(
    val route: String,
    val title: String? = null,
    val icon: ImageVector? = null
) {

    object CoinList : Screens(
        route = "coin_list",
        title = "Home",
        icon = Icons.Default.Home
    )

    object CoinDetail : Screens(route = "coin_detail")

    object CoinWatch : Screens(
        route = "coin_watch",
        title = "Watch",
        icon = Icons.Default.Favorite
    )

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
