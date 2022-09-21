package com.example.themoviedbapp.core.network

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface CoroutineDispatcherProvider {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
}

class CoroutineDispatcherProviderImpl(
    override val io: CoroutineDispatcher = Dispatchers.IO,
    override val main: CoroutineDispatcher = Dispatchers.Main,
    override val default: CoroutineDispatcher = Dispatchers.Default
) : CoroutineDispatcherProvider {

}