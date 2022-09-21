package com.example.themoviedbapp.common

import kotlinx.serialization.SerialName

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