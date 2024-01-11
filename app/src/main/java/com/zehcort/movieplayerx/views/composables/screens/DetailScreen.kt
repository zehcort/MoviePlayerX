package com.zehcort.movieplayerx.views.composables.screens

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.zehcort.domain.models.Movie
import com.zehcort.movieplayerx.viewmodels.MoviesViewModel
import com.zehcort.movieplayerx.views.composables.components.VideoPlayer

@Composable
fun DetailScreen(
    viewModel: MoviesViewModel,
    onBack: () -> Unit
) {
    BackHandler(onBack = onBack)

    val state = viewModel.state.value
    var orientation by remember { mutableIntStateOf(Configuration.ORIENTATION_PORTRAIT) }
    val configuration = LocalConfiguration.current

    state.selectedMovie?.let { movie ->
        when (orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                LandscapeContent(movie = movie)
            }

            else -> {
                PortraitContent(movie = movie)
            }
        }
    }

    LaunchedEffect(configuration) {
        // Save any changes to the orientation value on the configuration object
        snapshotFlow { configuration.orientation }
            .collect { orientation = it }
    }
}

@Composable
fun PortraitContent(movie: Movie) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        VideoPlayer(
            contentUrl = movie.sources[0],
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9F)
        )

        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            text = movie.title,
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
            text = movie.subtitle,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = movie.description,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun LandscapeContent(movie: Movie) {
    VideoPlayer(
        contentUrl = movie.sources[0],
        modifier = Modifier
            .fillMaxSize()
    )
}