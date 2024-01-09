package com.zehcort.movieplayerx.views.composables.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.zehcort.domain.models.Movie
import com.zehcort.domain.models.MovieCategory

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategorySection(
    category: MovieCategory,
    onDetail: (movie: Movie) -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState {
        category.videos.size
    }

    val localContext = LocalContext.current

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = category.name,
            fontWeight = FontWeight.Bold
        )

        HorizontalPager(
            state = pagerState,
            pageSize = PageSize.Fixed(200.dp),
            pageSpacing = 16.dp
        ) { page ->
            Column(
                modifier = Modifier.clickable { onDetail(category.videos[page]) }
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    model = ImageRequest.Builder(localContext).data(category.videos[page].thumb)
                        .crossfade(true).scale(Scale.FIT).build(),
                    contentDescription = category.videos[page].description
                )

                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = category.videos[page].title
                )

                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = category.videos[page].subtitle
                )
            }
        }
    }
}