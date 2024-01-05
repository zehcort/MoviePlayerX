package com.zehcort.domain.models

data class Movie(
    val title: String?,
    val subtitle: String?,
    val description: String?,
    val sources: List<String>?,
    val thumb: String?
)