package com.igor.data.model

import com.igor.domain.InvestmentParameters

data class Investment(
        val grossAmount: String,                // Valor bruto do investimento
        val taxesAmount: String,                // Valor do IR
        val netAmount: String,                  // Valor líquido
        val grossAmountProfit: String,          // Rentabilidade bruta
        val netAmountProfit: String,            // Rentabilidade líquida
        val annualGrossRateProfit: String,      // Rentabilidade bruta anual
        val monthlyGrossRateProfit: String,     // Rentabilidade bruta mensal
        val dailyGrossRateProfit: String,       // Rentabilidade bruta diária
        val taxesRate: String,                  // Faixa do IR (%)
        val rateProfit: String,                 // Rentabilidade no período
        val annualNetRateProfit: String,        // Rentabilidade líquida anual
        val investmentParameters: InvestmentParameters
)
