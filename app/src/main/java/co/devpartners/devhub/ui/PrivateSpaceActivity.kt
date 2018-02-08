package co.devpartners.devhub.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import co.devpartners.devhub.R
import co.devpartners.devhub.api.events.CustomDatePickerDialog
import kotlinx.android.synthetic.main.activity_private_space.*
import java.util.*

class PrivateSpaceActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener{



    var timepick = arrayOf("Hourly", "Daily", "Weekly")
    val datepicker = CustomDatePickerDialog()
    var spinner: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_private_space)



        spinner = this.spinnerView
        spinnerView.onItemSelectedListener = this

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, timepick)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerView!!.adapter = adapter

    }
    override fun onNothingSelected(adapterView: AdapterView<*>?) {

    }

    override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, p3: Long) {

    }
    fun checkinDate(view : View) {

        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, +1)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        var month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)

        val datepick = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view
                                                                                   , year
                                                                                   , monthOfYear
                                                                                   , day ->

            month = month +1
            checkinDatePickerButton.text = "$year/$monthOfYear/$day"
        }, year, month, day)
        datepick.show()
    }
    fun checkoutdate(view:View) {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, +1)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        var month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)

        val datepick = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view
                                                                                   , year

                                                                                   , monthOfYear
                                                                                   , day ->

            month = month + 1
            checkoutDatePickerButton.text = "$year/$monthOfYear/$day"
        }, year, month, day)
        datepick.show()

    }
}