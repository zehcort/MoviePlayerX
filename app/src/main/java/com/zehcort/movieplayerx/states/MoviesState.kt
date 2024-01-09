package com.zehcort.movieplayerx.states

import com.zehcort.domain.models.Movie
import com.zehcort.domain.models.MovieCategory

data class MoviesState(
    var isLoading: Boolean = true,
    var movieCategories: List<MovieCategory> = emptyList(),
    var selectedMovie: Movie? = null
)
