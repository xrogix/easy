package com.igor.domain.entity

data class InvestmentParameters(
    val investedAmount: String,        // O valor a ser investido
    val yearlyInterestRate: String,    // Rentabilidade anual
    val maturityTotalDays: String,     // Dias corridos
    val maturityBusinessDays: String,  // Dias úteis
    val maturityDate: String,          // Data de vencimento
    val rate: String,                  // Percentual do papel
    val isTaxFree: Boolean             // Isento de IR
)