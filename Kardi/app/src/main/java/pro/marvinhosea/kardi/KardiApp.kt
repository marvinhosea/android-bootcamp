package pro.marvinhosea.kardi

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pro.marvinhosea.kardi.di.repositoryModule
import pro.marvinhosea.kardi.di.viewModelModule

class KardiApp: Application(){
    companion object {
        private lateinit var instance: KardiApp
        fun getAppContext() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidContext(this@KardiApp)
            modules(listOf(repositoryModule, viewModelModule))
        }
    }
}