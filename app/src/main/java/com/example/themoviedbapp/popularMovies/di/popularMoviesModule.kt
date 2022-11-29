package com.example.themoviedbapp.popularMovies.di

import com.example.themoviedbapp.core.network.CoroutineDispatcherProvider
import com.example.themoviedbapp.core.network.CoroutineDispatcherProviderImpl
import com.example.themoviedbapp.di.BASE_API
import com.example.themoviedbapp.popularMovies.data.dataSource.PopularMoviesDataSource
import com.example.themoviedbapp.popularMovies.data.repository.PopularMoviesRepositoryImpl
import com.example.themoviedbapp.popularMovies.domain.repository.PopularMoviesRepository
import com.example.themoviedbapp.popularMovies.domain.usecase.GetPopularMoviesUseCase
import com.example.themoviedbapp.popularMovies.presentation.PopularMoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val popularMoviesModule = module {

    viewModel {
        PopularMoviesViewModel(
            getPopularMoviesUseCase = get(),
            dispatcherProvider = get()
        )
    }

    factory {
        GetPopularMoviesUseCase(
            popularMoviesRepository = get()
        )
    }

    factory<PopularMoviesRepository> {
        PopularMoviesRepositoryImpl(
            popularMoviesDataSource = get()
        )
    }

    single {
        val retrofit = get<Retrofit.Builder>(named(BASE_API)).build()
        retrofit.create(PopularMoviesDataSource::class.java)
    }


    factory<CoroutineDispatcherProvider> {
        CoroutineDispatcherProviderImpl()
    }
}