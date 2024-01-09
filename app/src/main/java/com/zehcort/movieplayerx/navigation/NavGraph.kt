package com.zehcort.movieplayerx.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zehcort.movieplayerx.viewmodels.MoviesViewModel
import com.zehcort.movieplayerx.views.composables.screens.DetailScreen
import com.zehcort.movieplayerx.views.composables.screens.HomeScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Route.Home.route
    ) {
        composable(Route.Home.route) {
            HomeScreen(
                onDetail = { navController.navigate(Route.Detail.route) }
            )
        }
        composable(Route.Detail.route) { backStackEntry ->
            val homeEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Route.Home.route)
            }
            val moviesViewModel = hiltViewModel<MoviesViewModel>(homeEntry)

            DetailScreen(
                viewModel = moviesViewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}