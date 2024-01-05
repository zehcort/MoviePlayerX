package com.zehcort.domain.usecases

import com.zehcort.domain.companions.Resource
import com.zehcort.domain.models.MovieCategory
import com.zehcort.domain.repositories.MovieCategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieCategories @Inject constructor(
    private val repository: MovieCategoryRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<MovieCategory>>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getMovieCategories()
            emit(Resource.Success(response))
        } catch (ex: Exception) {
            emit(Resource.Error(message = ex.message!!, stacktrace = ex.stackTrace))
        }
    }
}