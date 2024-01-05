package com.zehcort.data.apis.gist

import com.zehcort.data.entities.gist.Response
import retrofit2.http.GET

interface MovieApi {
    @GET(value = Constants.GIST_MOVIES)
    suspend fun getMovieCategories(): Response
}