package com.igor.data.provider

import com.igor.domain.entity.Investment
import retrofit2.Call

interface SimulatorProviderInterface {
    fun listRepos(
        investedAmount: String,
        index: String,
        rate: String,
        isTaxFree: Boolean,
        maturityDate: String
    ) : Call<Investment>
}