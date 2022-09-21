package com.example.themoviedbapp.core.result

import java.lang.Exception

sealed interface BaseResultDomain<out T> {

    data class Success<T>(val data: T) : BaseResultDomain<T>

    data class Error<T>(val exception: Exception? = null): BaseResultDomain<T>
}