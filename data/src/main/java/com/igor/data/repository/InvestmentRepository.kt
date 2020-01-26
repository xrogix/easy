package com.igor.data.repository

import com.igor.domain.entity.Investment
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface InvestmentRepository {
    @GET("calculator/simulate")
    fun listRepos(
            @Query("investedAmount") investedAmount: String,
            @Query("index") index: String,
            @Query("rate") rate: String,
            @Query("isTaxFree") isTaxFree: Boolean,
            @Query("maturityDate") maturityDate: String
    ) : Call<Investment>
}