package com.example.themoviedbapp.popularMovies.data.repository

import com.example.themoviedbapp.core.result.BaseResultDomain
import com.example.themoviedbapp.core.network.UnexpectedException
import com.example.themoviedbapp.popularMovies.data.dataSource.PopularMoviesDataSource
import com.example.themoviedbapp.popularMovies.domain.model.Movie
import com.example.themoviedbapp.popularMovies.domain.repository.PopularMoviesRepository

class PopularMoviesRepositoryImpl(
    private val popularMoviesDataSource: PopularMoviesDataSource,
) : PopularMoviesRepository {
    override suspend fun getPopularMovies(): BaseResultDomain<List<Movie>> {
        val response = popularMoviesDataSource.getPopularMovies()
        val result = response.body()
            ?: return BaseResultDomain.Error(UnexpectedException("unexpected error"))
        if (response.isSuccessful) {
            return BaseResultDomain.Success(result.results.map { it.fromDto() })
        }
        return BaseResultDomain.Error(UnexpectedException("unexpected error"))

        /*try {
            val response = colorDataSource.getColors().execute()
            val result = response.body() ?: return BaseResultDomain.Error(UnexpectedException("unexpected message"))
            if (response.isSuccessful) {

                return BaseResultDomain.Success(result.map { it.mapToDomain() })
            }

            return response.errorBody().toErrorResultDomain()
        } catch (e: Exception) {

            return BaseResultDomain.Error(exception = e)
        }*/

    }
}