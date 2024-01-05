package com.zehcort.movieplayerx.states

import com.zehcort.domain.models.MovieCategory

data class HomeState(
    var isLoading: Boolean = true,
    var movieCategories: List<MovieCategory> = emptyList(),
)
