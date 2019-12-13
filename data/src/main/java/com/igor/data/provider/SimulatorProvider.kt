package com.igor.data.provider

import com.igor.data.model.Investment
import com.igor.data.service.SimulatorService
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class SimulatorProvider(
    private val stringProvider: StringProviderInterface
) : SimulatorProviderInterface {

    private fun prepare() : SimulatorService {
        val retrofit = Retrofit.Builder()
                .baseUrl(stringProvider.baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        return retrofit.create(SimulatorService::class.java)
    }

    override fun listRepos(
        investedAmount: String,
        index: String,
        rate: String,
        isTaxFree: Boolean,
        maturityDate: String
    ): Call<Investment> {
        return prepare().listRepos(
            investedAmount,
            index,
            rate,
            isTaxFree,
            maturityDate
        )
    }
}