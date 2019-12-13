package com.igor.easy.view.investment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.igor.easy.R
import org.koin.android.viewmodel.ext.android.sharedViewModel

class InvestmentFragment : Fragment() {

    private val mViewModel by sharedViewModel<InvestmentViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_investment, container, false)
    }

    companion object {
        fun newInstance() = InvestmentFragment()
    }
}
