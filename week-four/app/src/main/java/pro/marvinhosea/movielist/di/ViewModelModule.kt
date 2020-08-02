package pro.marvinhosea.movielist.di

import org.koin.core.module.Module
import org.koin.dsl.module
import pro.marvinhosea.movielist.ui.movies.MovieViewModel

val viewModelModule: Module = module {
    factory {
        MovieViewModel(get())
    }
}