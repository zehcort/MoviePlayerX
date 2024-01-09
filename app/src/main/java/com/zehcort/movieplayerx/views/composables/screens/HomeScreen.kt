package com.zehcort.movieplayerx.views.composables.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.zehcort.movieplayerx.viewmodels.HomeViewModel
import com.zehcort.movieplayerx.views.composables.components.CategorySection
import com.zehcort.movieplayerx.views.composables.components.LoadingIndicator

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    if (state.isLoading) {
        LoadingIndicator()
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            CategorySection(category = state.movieCategories[0])
        }
    }

    DisposableEffect(key1 = Unit, effect = {
        viewModel.fetchMovieCategories()

        onDispose {
            viewModel.resetMovieCategoriesState()
        }
    })
}