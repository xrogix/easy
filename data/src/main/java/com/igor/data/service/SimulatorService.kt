package com.igor.data.service

import com.igor.data.model.Investment
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SimulatorService {
    @GET("calculator/simulate")
    fun listRepos(
            @Path("investedAmount") investmentAmount: String,
            @Path("index") index: String,
            @Path("rate") rate: String,
            @Path("isTaxFree") isTaxFree: Boolean,
            @Path("maturityDate") maturityDate: String
    ) : Call<Investment>
}