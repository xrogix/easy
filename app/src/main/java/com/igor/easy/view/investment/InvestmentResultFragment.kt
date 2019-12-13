package com.igor.easy.view.investment

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.igor.easy.R
import kotlinx.android.synthetic.main.fragment_investment_result.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class InvestmentResultFragment : Fragment() {

    private val mViewModel by sharedViewModel<InvestmentViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_investment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        mViewModel.investment.observe(this, Observer {

            initial_invoice.text = it?.investmentParameters?.investedAmount
            gross_amount.text = it?.grossAmount
            rental_invoice.text = it?.netAmountProfit
            ir_invoice.text = it?.taxesAmount
            liquid_invoice.text = it?.netAmountProfit
            date_rescue.text = it?.investmentParameters?.maturityDate
            days_current.text = it?.investmentParameters?.maturityTotalDays
            month_yield.text = it?.monthlyGrossRateProfit
            percent_cdi.text = it?.investmentParameters?.rate
            year_yield.text = it?.annualGrossRateProfit
            period_yield.text = it?.rateProfit

        })
    }

    companion object {
        fun newInstance() = InvestmentResultFragment()
    }
}
