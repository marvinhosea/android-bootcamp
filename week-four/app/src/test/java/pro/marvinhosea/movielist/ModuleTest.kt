package pro.marvinhosea.movielist

import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import pro.marvinhosea.movielist.di.networkModule
import pro.marvinhosea.movielist.di.repositoryModule
import pro.marvinhosea.movielist.di.viewModelModule

class ModuleTest : KoinTest {
    @Test
    fun `Test Koin Module`() {
        startKoin() {
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }.checkModules()

        stopKoin()
    }
}