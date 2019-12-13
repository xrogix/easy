package com.igor.easy.view.investment

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.igor.easy.R
import org.koin.android.viewmodel.ext.android.viewModel

class InvestmentActivity : AppCompatActivity() {

    private val mViewModel by viewModel<InvestmentViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_investment)

        init()
        listeners()
    }

    private fun init() {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.add(R.id.content, InvestmentFragment.newInstance())
        ft.commit()
    }

    private fun listeners() {
        mViewModel.success.observe(this, Observer {
            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.content, InvestmentResultFragment.newInstance())
            ft.commit()
        })

        mViewModel.reSimulate.observe(this, Observer {
            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.content, InvestmentFragment.newInstance())
            ft.commit()
        })
    }
}
