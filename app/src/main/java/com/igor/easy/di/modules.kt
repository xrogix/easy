package com.igor.easy.di

import com.igor.data.provider.SimulatorProvider
import com.igor.data.provider.StringProvider
import com.igor.easy.view.investment.InvestmentViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appViewModel = module {
    viewModel { InvestmentViewModel(get()) }
}

val appModule = module {
    single { StringProvider() }
    single { SimulatorProvider(get()) }
}