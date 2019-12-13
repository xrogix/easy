package com.igor.easy.view.investment

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.igor.easy.R
import org.koin.android.architecture.ext.viewModel

class InvestmentActivity : AppCompatActivity() {

    private val mViewModel by viewModel<InvestmentViewModel>()

    private val fm = supportFragmentManager
    private val ft = fm.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_investment)

        init()
        listeners()
    }

    private fun init() {
        ft.add(R.id.content, InvestmentFragment.newInstance())
        ft.commit()
    }

    private fun listeners() {
        mViewModel.success.observe(this, Observer {
            ft.replace(R.id.content, InvestmentResultFragment.newInstance())
        })
    }
}
