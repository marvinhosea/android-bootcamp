package pro.marvinhosea.kardi.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import pro.marvinhosea.kardi.ui.game.GameViewModel
import pro.marvinhosea.kardi.ui.home.HomeViewModel

val viewModelModule: Module = module {
    viewModel { GameViewModel(get()) }
    viewModel { HomeViewModel(get()) }
}