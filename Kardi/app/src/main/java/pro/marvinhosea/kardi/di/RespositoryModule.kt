package pro.marvinhosea.kardi.di

import org.koin.core.module.Module
import org.koin.dsl.module
import pro.marvinhosea.kardi.KardiApp
import pro.marvinhosea.kardi.db.models.KardiDb
import pro.marvinhosea.kardi.respository.GameRepository

val repositoryModule: Module =  module {
    single {
        KardiDb.getInstance(KardiApp.getAppContext())
    }

    single {
        GameRepository(get())
    }
}