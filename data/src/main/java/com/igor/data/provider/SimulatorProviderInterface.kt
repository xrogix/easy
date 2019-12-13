package com.igor.data.provider

import com.igor.data.model.Investment
import retrofit2.Call

interface SimulatorProviderInterface {
    fun listRepos(
        investmentAmount: String,
        index: String,
        rate: String,
        isTaxFree: Boolean,
        maturityDate: String
    ) : Call<Investment>
}