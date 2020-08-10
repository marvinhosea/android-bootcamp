package pro.marvinhosea.movielist.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import pro.marvinhosea.movielist.ui.movies.MovieViewModel
import pro.marvinhosea.movielist.ui.movies.show.MovieDetailViewModel

val viewModelModule: Module = module {
    viewModel { MovieViewModel(get(), get()) }
    viewModel { MovieDetailViewModel(get()) }
}