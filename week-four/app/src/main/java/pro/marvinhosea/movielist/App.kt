package pro.marvinhosea.movielist

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pro.marvinhosea.movielist.di.networkModule
import pro.marvinhosea.movielist.di.repositoryModule
import pro.marvinhosea.movielist.di.viewModelModule

class App : Application() {
    companion object {
        private lateinit var instance: App
        fun getAppContext() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
    }
}