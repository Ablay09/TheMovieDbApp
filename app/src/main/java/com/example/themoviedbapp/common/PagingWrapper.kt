package com.example.themoviedbapp.common

import com.example.themoviedbapp.popularMovies.data.model.MovieDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PagingWrapper<out T>(
    @SerialName("page")
    val page: Long? = null,
    @SerialName("total_results")
    val totalResults: Long? = null,
    @SerialName("total_pages")
    val totalPages: Long? = null,
    @SerialName("results")
    val results: List<T> = emptyList()
)