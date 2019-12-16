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
import java.text.SimpleDateFormat
import java.util.*
import android.app.DatePickerDialog

class InvestmentFragment : Fragment() {

    private val mViewModel by sharedViewModel<InvestmentViewModel>()
    val myCalendar = Calendar.getInstance()

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

        //value to investment
        invoice.afterTextChanged {
            mViewModel.setInvoice(it)
            mViewModel.listenFields()
        }

        //date calendar
        val date = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, monthOfYear)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel()
        }
        maturity_date.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus)
                context?.let {
                    DatePickerDialog(it, date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show()
                }
        }

        //rate
        rate.afterTextChanged {
            mViewModel.setRate(it)
            mViewModel.listenFields()
        }
        rate.filters = arrayOf<InputFilter>(InputFilterMinMax(1, 100))


        //button to result
        btn_simulate.setOnClickListener {
            mViewModel.simulate()
        }
    }

    private fun updateLabel() {
        val myFormat = "yyyy-MM-dd" //In which you need put here
        val sdf = SimpleDateFormat(myFormat, Locale("pt", "BR"))

        maturity_date.setText(sdf.format(myCalendar.time))
        mViewModel.setMaturity(sdf.format(myCalendar.time))
        mViewModel.listenFields()
    }

    companion object {
        fun newInstance() = InvestmentFragment()
    }
}
