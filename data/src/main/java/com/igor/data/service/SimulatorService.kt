package com.igor.data.service

import com.igor.data.model.Investment
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SimulatorService {
    @GET("calculator/simulate")
    fun listRepos(
            @Query("investedAmount") investedAmount: String,
            @Query("index") index: String,
            @Query("rate") rate: String,
            @Query("isTaxFree") isTaxFree: Boolean,
            @Query("maturityDate") maturityDate: String
    ) : Call<Investment>
}