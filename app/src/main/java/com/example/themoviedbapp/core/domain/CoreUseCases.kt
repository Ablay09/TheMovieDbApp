package com.example.themoviedbapp.core.domain

interface CoreSuspendUseCase<in I, out V: Any> {

    suspend fun execute(param: I): V
}

interface CoreSuspendNonParamsUseCase<out V: Any> {

    suspend fun execute(): V

}