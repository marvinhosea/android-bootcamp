package pro.marvinhosea.movielist.di

import org.koin.core.module.Module
import org.koin.dsl.module
import pro.marvinhosea.movielist.App
import pro.marvinhosea.movielist.data.db.MovieDatabase
import pro.marvinhosea.movielist.data.db.dao.MovieDao
import pro.marvinhosea.movielist.networking.RemoteApi
import pro.marvinhosea.movielist.repository.MoviesRepository
import pro.marvinhosea.movielist.repository.UserSharedPrefRepository

val repositoryModule: Module = module {
    single {
        MovieDatabase.getDatabase(App.getAppContext()).movieDao()
    }
    single {
        MoviesRepository(get(), get())
    }

    single {
        UserSharedPrefRepository
    }
}