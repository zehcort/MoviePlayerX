package com.zehcort.data.dtos

import com.zehcort.data.entities.gist.Movie as MovieEntity
import com.zehcort.data.entities.gist.MovieCategory as MovieCategoryEntity
import com.zehcort.domain.models.Movie as MovieDomain
import com.zehcort.domain.models.MovieCategory as MovieCategoryDomain

fun MovieCategoryEntity.toDomain(): MovieCategoryDomain = MovieCategoryDomain(
    name = name,
    videos = videos.toDomain()
)

private fun List<MovieEntity>.toDomain(): List<MovieDomain> {
    return this.map {
        MovieDomain(
            title = it.title ?: "",
            subtitle = it.subtitle ?: "",
            description = it.description ?: "",
            sources = it.sources ?: listOf(),
            thumb = it.thumb
        )
    }
}