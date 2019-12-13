package com.igor.easy.view.investment

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.igor.easy.R
import org.koin.android.viewmodel.ext.android.viewModel

class InvestmentActivity : AppCompatActivity() {

    private val mViewModel by viewModel<InvestmentViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_investment)
    }

}
