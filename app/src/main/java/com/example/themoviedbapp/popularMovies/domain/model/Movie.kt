package com.example.themoviedbapp.popularMovies.domain.model

data class Movie(
    val id: Long?,
    val isAdult: Boolean?,
    val posterPath: String?,
    val overview: String?,
    val releaseDate: String?,
    val title: String?,
    val genreIds: List<Int>?,
    val originalTitle: String?,
    val originalLanguage: String?,
    val backdropPath: String?,
    val popularity: Float,
    val voteCount: Long,
    val hasVideo: Boolean?,
    val voteAverage: Float?
)