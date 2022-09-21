package com.example.themoviedbapp.popularMovies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviedbapp.core.network.CoroutineDispatcherProvider
import com.example.themoviedbapp.core.result.BaseResultDomain
import com.example.themoviedbapp.popularMovies.domain.model.Movie
import com.example.themoviedbapp.popularMovies.domain.usecase.GetPopularMoviesUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PopularMoviesViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val dispatcherProvider: CoroutineDispatcherProvider
) : ViewModel() {

    fun getPopularMovies() {
        viewModelScope.launch {
            val result: BaseResultDomain<List<Movie>> = withContext(dispatcherProvider.io) {
                getPopularMoviesUseCase.execute()
            }
            when {
                result is BaseResultDomain.Success -> {

                }
                result is BaseResultDomain.Error -> {

                }
            }
        }
    }
}