package com.example.themoviedbapp.popularMovies.data.model

import com.example.themoviedbapp.popularMovies.domain.model.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    @SerialName("id")
    val id: Long?,
    @SerialName("adult")
    val isAdult: Boolean?,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("overview")
    val overview: String?,
    @SerialName("release_date")
    val releaseDate: String?,
    @SerialName("genre_ids")
    val genreIds: List<Int>?,
    @SerialName("original_title")
    val originalTitle: String?,
    @SerialName("original_language")
    val originalLanguage: String?,
    @SerialName("backdrop_path")
    val backdropPath: String?,
    @SerialName("popularity")
    val popularity: Float,
    @SerialName("vote_count")
    val voteCount: Long,
    @SerialName("video")
    val hasVideo: Boolean?,
    @SerialName("vote_average")
    val voteAverage: Float?
) {
    fun fromDto(): Movie {
        return Movie(
            id,
            isAdult,
            posterPath,
            overview,
            releaseDate,
            genreIds,
            originalTitle,
            originalLanguage,
            backdropPath,
            popularity,
            voteCount,
            hasVideo,
            voteAverage
        )
    }
}