package com.example.themoviedbapp.popularMovies.domain.usecase

import com.example.themoviedbapp.core.domain.CoreSuspendNonParamsUseCase
import com.example.themoviedbapp.core.result.BaseResultDomain
import com.example.themoviedbapp.popularMovies.domain.model.Movie
import com.example.themoviedbapp.popularMovies.domain.repository.PopularMoviesRepository

class GetPopularMoviesUseCase(
    private val popularMoviesRepository: PopularMoviesRepository
) : CoreSuspendNonParamsUseCase<BaseResultDomain<List<Movie>>> {

    override suspend fun execute(): BaseResultDomain<List<Movie>> {
        return popularMoviesRepository.getPopularMovies()
    }
}

//data class GetPopularMoviesResult(
//    val popularMovies: List<Movie>
//)