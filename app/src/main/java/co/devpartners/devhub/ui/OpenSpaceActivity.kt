package co.devpartners.devhub.ui

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import co.devpartners.devhub.R
import co.devpartners.devhub.api.events.CustomDatePickerDialog
import co.devpartners.devhub.api.model.DatePickerType
import kotlinx.android.synthetic.main.activity_conference.*
import kotlinx.android.synthetic.main.activity_open_space.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.textView
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.AM_PM
import java.util.Calendar.MONTH

class OpenSpaceActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {

    val datepicker = CustomDatePickerDialog()
    var timepick = arrayOf("Hourly", "Daily", "Weekly")
    var spinner: Spinner? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_space)



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

    fun checkinDate(view: View) {
        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        var month = calendar.get(MONTH)
        val year = calendar.get(Calendar.YEAR)


        val datepick = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view
                                                                                   , year
                                                                                   , monthOfYear
                                                                                   , day ->
            checkinDatePickerButton.text = "" + year + "/" + (monthOfYear + 1) + "/" + day
        }, year, month, day)
        datepick.show()
    }
    fun checkoutDate(view: View) {

        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)


        val datepick = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view
                                                                                   , year
                                                                                   , monthOfYear
                                                                                   , day ->


            checkoutDatePickerButton.text = "" + year + "/" + (monthOfYear + 1) + "/" + day
        }, year, month, day)

            datepick.show()
        }
        @SuppressLint("SetTextI18n")
        fun checkintime(view: View) {
            val cal = Calendar.getInstance()

            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                var AM_PM: String
                if (hour < 12) {
                    AM_PM = "AM"
                } else {
                    AM_PM = "PM"
                }
                checkinTimePicker.text = SimpleDateFormat("HH:mm").format(cal.time) + AM_PM
            }

            checkinTimePicker.setOnClickListener {
                TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), false).show()
            }
        }

        fun checkouttime(view: View) {
            val cal = Calendar.getInstance()

            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                var AM_PM: String
                if (hour < 12) {
                    AM_PM = "AM"
                } else {
                    AM_PM = "PM"
                }
                checkoutTimePicker.text = SimpleDateFormat("HH:mm").format(cal.time) + AM_PM
            }
            checkoutTimePicker.setOnClickListener {
                TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), false).show()
            }
        }
    }


