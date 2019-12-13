package com.igor.easy.di

import com.igor.data.provider.SimulatorProvider
import com.igor.data.provider.SimulatorProviderInterface
import com.igor.data.provider.StringProvider
import com.igor.data.provider.StringProviderInterface
import com.igor.easy.view.investment.InvestmentViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { InvestmentViewModel(get()) }

    single { StringProvider() as StringProviderInterface }

    factory { SimulatorProvider(get()) as SimulatorProviderInterface }
}