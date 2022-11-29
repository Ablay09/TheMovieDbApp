package com.example.themoviedbapp.di

import com.example.themoviedbapp.popularMovies.di.popularMoviesModule
import org.koin.core.module.Module

val allModules = listOf<Module>(
    networkModule,
    popularMoviesModule
)