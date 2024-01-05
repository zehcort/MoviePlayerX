package com.zehcort.domain.repositories

import com.zehcort.domain.models.MovieCategory

interface MovieCategoryRepository {
    suspend fun getMovieCategories(): List<MovieCategory>
}