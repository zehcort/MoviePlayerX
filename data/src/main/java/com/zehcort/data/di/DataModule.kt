package com.zehcort.data.di

import com.zehcort.data.apis.gist.Constants
import com.zehcort.data.apis.gist.MovieApi
import com.zehcort.data.repositories.MovieCategoryRepositoryImpl
import com.zehcort.domain.repositories.MovieCategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideGistMovieApi(): MovieApi {
        return Retrofit.Builder().baseUrl(Constants.GIST_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(repository: MovieApi): MovieCategoryRepository {
        return MovieCategoryRepositoryImpl(repository)
    }
}