package com.igor.easy.view.investment

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.igor.easy.R
import com.igor.easy.extensions.formatDate
import com.igor.easy.extensions.toCurrency
import com.igor.easy.extensions.toPercent
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
        listeners()
    }

    private fun init() {
        mViewModel.investment.observe(this, Observer {

            txtValue.text = it?.grossAmount?.toCurrency()
            initial_invoice.text = it?.investmentParameter?.investedAmount?.toCurrency()
            gross_amount.text = it?.grossAmount?.toCurrency()
            rental_invoice.text = it?.netAmountProfit?.toCurrency()
            ir_invoice.text = it?.taxesAmount?.toCurrency()
            liquid_invoice.text = it?.netAmountProfit?.toCurrency()

            date_rescue.text = it?.investmentParameter?.maturityDate?.formatDate()
            days_current.text = it?.investmentParameter?.maturityTotalDays
            month_yield.text = it?.monthlyGrossRateProfit?.toPercent()
            percent_cdi.text = it?.investmentParameter?.rate?.toPercent()
            year_yield.text = it?.annualGrossRateProfit?.toPercent()
            period_yield.text = it?.rateProfit?.toPercent()

        })
    }

    private fun listeners() {
        btn_resimulate.setOnClickListener {
            mViewModel.reSimulate()
        }
    }

    companion object {
        fun newInstance() = InvestmentResultFragment()
    }
}
