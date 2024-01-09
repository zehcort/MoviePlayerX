package com.zehcort.movieplayerx.views.composables.components

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

@Composable
fun VideoPlayer(
    contentUrl: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(Uri.parse(contentUrl)))
            prepare()
            play()
        }
    }

    AndroidView(
        factory = { context ->
            StyledPlayerView(context).apply {
                player = exoPlayer
            }
        },
        modifier = modifier
    )

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }
}