package com.example.themoviedbapp.popularMovies.domain.repository

import com.example.themoviedbapp.core.result.BaseResultDomain
import com.example.themoviedbapp.popularMovies.domain.model.Movie

interface PopularMoviesRepository {

    suspend fun getPopularMovies(): BaseResultDomain<List<Movie>>
}