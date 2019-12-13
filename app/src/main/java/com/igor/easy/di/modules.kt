package com.igor.easy.di

import com.igor.data.provider.SimulatorProvider
import com.igor.data.provider.SimulatorProviderInterface
import com.igor.data.provider.StringProvider
import com.igor.data.provider.StringProviderInterface
import com.igor.easy.view.investment.InvestmentViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

val appModule = applicationContext {
    viewModel { InvestmentViewModel(get()) }

    bean { StringProvider() as StringProviderInterface }

    bean { SimulatorProvider(get()) as SimulatorProviderInterface }
}