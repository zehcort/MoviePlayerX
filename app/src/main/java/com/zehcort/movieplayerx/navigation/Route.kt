package com.zehcort.movieplayerx.navigation

sealed class Route(val route: String) {
    data object Home : Route("Home")
    data object Detail : Route("Detail")
}