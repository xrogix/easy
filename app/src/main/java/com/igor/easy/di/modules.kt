package com.igor.easy.di

import com.igor.easy.view.investment.InvestmentViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { InvestmentViewModel() }
}