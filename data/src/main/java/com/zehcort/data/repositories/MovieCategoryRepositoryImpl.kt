package com.zehcort.data.repositories

import com.zehcort.data.apis.gist.MovieApi
import com.zehcort.data.dtos.toDomain
import com.zehcort.domain.models.MovieCategory
import com.zehcort.domain.repositories.MovieCategoryRepository
import javax.inject.Inject

class MovieCategoryRepositoryImpl @Inject constructor(
    private val gistMovieApi: MovieApi
) : MovieCategoryRepository {
    override suspend fun getMovieCategories(): List<MovieCategory> =
        gistMovieApi.getMovieCategories().categories.map { it.toDomain() }
}