package com.igor.easy.view.investment

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.igor.easy.R
import com.igor.easy.extensions.afterTextChanged
import kotlinx.android.synthetic.main.fragment_investment.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import com.igor.easy.helper.InputFilterMinMax
import android.text.InputFilter



class InvestmentFragment : Fragment() {

    private val mViewModel by sharedViewModel<InvestmentViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_investment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listeners()
        actions()
    }

    private fun listeners() {
        mViewModel.btnSimulation.observe(this, Observer {
            it?.apply {
                btn_simulate.isEnabled = this
            }
        })
    }

    private fun actions() {
        invoice.afterTextChanged {
            mViewModel.setInvoice(it)
            mViewModel.listenFields()
        }
        maturity_date.afterTextChanged {
            mViewModel.setMaturity(it)
            mViewModel.listenFields()
        }
        rate.afterTextChanged {
            mViewModel.setRate(it)
            mViewModel.listenFields()
        }
        rate.filters = arrayOf<InputFilter>(InputFilterMinMax(1, 100))

        btn_simulate.setOnClickListener {
            mViewModel.simulate()
        }
    }

    companion object {
        fun newInstance() = InvestmentFragment()
    }
}
