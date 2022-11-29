package com.example.themoviedbapp.popularMovies.data.dataSource

import com.example.themoviedbapp.common.PagingWrapper
import com.example.themoviedbapp.core.network.NetworkConstants
import com.example.themoviedbapp.popularMovies.data.model.MovieDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularMoviesDataSource {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = NetworkConstants.API_KEY,
        @Query("language") language: String? = null,
        @Query("page") page: Long? = null,
        @Query("region") region: String? = null
    ): Response<PagingWrapper<MovieDto>>
}