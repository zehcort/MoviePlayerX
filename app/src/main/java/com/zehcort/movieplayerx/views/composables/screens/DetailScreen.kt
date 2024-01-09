package com.zehcort.movieplayerx.views.composables.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.zehcort.movieplayerx.viewmodels.MoviesViewModel
import com.zehcort.movieplayerx.views.composables.components.VideoPlayer

@Composable
fun DetailScreen(
    viewModel: MoviesViewModel,
    onBack: () -> Unit
) {
    BackHandler(onBack = onBack)

    val state = viewModel.state.value

    state.selectedMovie?.let { movie ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            VideoPlayer(
                contentUrl = movie.sources[0],
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = movie.title,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = movie.subtitle,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = movie.description,
                fontWeight = FontWeight.Medium
            )
        }
    }
}