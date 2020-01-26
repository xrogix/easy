package com.igor.easy.view.investment

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.igor.data.provider.SimulatorProviderInterface
import com.igor.domain.entity.Investment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InvestmentViewModel(
        private val provider: SimulatorProviderInterface
) : ViewModel() {

    private val mInvoice = MutableLiveData<String>()
    private val mIndex = MutableLiveData<String>().apply {
        value = "CDI"
    }
    private val mRate = MutableLiveData<String>()
    private val mIsTaxFree = MutableLiveData<Boolean>().apply {
        value = false
    }
    private val mMaturityDate = MutableLiveData<String>()
    private val mSuccess = MutableLiveData<Boolean>()
    private val mError = MutableLiveData<String>()
    private val mInvestment = MutableLiveData<Investment>()
    private val mBtnSimulate = MutableLiveData<Boolean>().apply {
        value = false
    }
    private val mReSimulate = MutableLiveData<Boolean>()

    val invoice: LiveData<String> get() = mInvoice
    val maturityDate: LiveData<String> get() = mMaturityDate
    val rate: LiveData<String> get() = mRate
    val success: LiveData<Boolean> get() = mSuccess
    val error: LiveData<String> get() = mError
    val btnSimulation: LiveData<Boolean> get() = mBtnSimulate
    val investment: LiveData<Investment> get() = mInvestment
    val reSimulate: LiveData<Boolean> get() = mReSimulate

    fun listenFields() {
        when {
            invoice.value.isNullOrEmpty() && maturityDate.value.isNullOrEmpty() && rate.value.isNullOrEmpty() -> mBtnSimulate.postValue(false)
            else -> mBtnSimulate.postValue(true)
        }
    }

    fun simulate() {
        provider.listRepos(
                invoice.value!!,
                mIndex.value!!,
                mRate.value!!,
                mIsTaxFree.value!!,
                mMaturityDate.value!!
        ).enqueue(object: Callback<Investment> {
            override fun onFailure(call: Call<Investment>?, t: Throwable?) {
                t?.run {
                    mError.postValue(message)
                }
            }

            override fun onResponse(call: Call<Investment>?, response: Response<Investment>?) {
                response?.run {
                    mSuccess.postValue(true)
                    mInvestment.postValue(response.body())
                }
            }

        })
    }

    fun setInvoice(invoice: String) {
        mInvoice.postValue(invoice)
    }

    fun setMaturity(maturity: String) {
        mMaturityDate.postValue(maturity)
    }

    fun setRate(rate: String) {
        mRate.postValue(rate)
    }

    fun reSimulate() {
        mReSimulate.value = true
    }

}