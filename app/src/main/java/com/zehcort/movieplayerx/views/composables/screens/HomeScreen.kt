package com.zehcort.movieplayerx.views.composables.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.zehcort.movieplayerx.viewmodels.HomeViewModel
import com.zehcort.movieplayerx.views.composables.components.LoadingIndicator

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    if (state.isLoading) {
        LoadingIndicator()
    } else {
        Text(text = state.movieCategories.toString())
    }

    DisposableEffect(key1 = Unit, effect = {
        viewModel.fetchMovieCategories()

        onDispose { }
    })
}