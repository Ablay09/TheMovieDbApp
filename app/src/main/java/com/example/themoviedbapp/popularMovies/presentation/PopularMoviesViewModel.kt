package com.example.themoviedbapp.popularMovies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviedbapp.core.network.CoroutineDispatcherProvider
import com.example.themoviedbapp.core.result.BaseResultDomain
import com.example.themoviedbapp.popularMovies.domain.model.Movie
import com.example.themoviedbapp.popularMovies.domain.usecase.GetPopularMoviesUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PopularMoviesViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val dispatcherProvider: CoroutineDispatcherProvider
) : ViewModel() {

    val loaderLiveData: LiveData<Boolean>
        get() = _loaderLiveData
    private val _loaderLiveData = MutableLiveData<Boolean>()

    val errorLiveData: LiveData<String>
        get() = _errorLiveData
    private val _errorLiveData = MutableLiveData<String>()

    val popularMoviesLiveData: LiveData<List<Movie>>
        get() = _popularMoviesLiveData
    private val _popularMoviesLiveData = MutableLiveData<List<Movie>>()

    fun getPopularMovies() {
        viewModelScope.launch {
            _loaderLiveData.value = true
            val result: BaseResultDomain<List<Movie>> = withContext(dispatcherProvider.io) {
                getPopularMoviesUseCase.execute()
            }
            _loaderLiveData.value = false
            when {
                result is BaseResultDomain.Success -> {
                    val popularMovies = result.data
                    _popularMoviesLiveData.value = popularMovies
                }
                result is BaseResultDomain.Error -> {
                    _errorLiveData.value = result.exception?.message.orEmpty()
                }
            }
        }
    }
}