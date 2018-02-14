package co.devpartners.devhub.ui


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.*
import co.devpartners.devhub.R
import co.devpartners.devhub.api.events.CheckInTimeDialog
import co.devpartners.devhub.api.events.CustomDatePickerDialog
import co.devpartners.devhub.api.model.DatePickerType
import kotlinx.android.synthetic.main.activity_open_space.*
import org.jetbrains.anko.startActivity


class OpenSpaceActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {

    val datepicker = CustomDatePickerDialog()
    var timepick = arrayOf("Length of Stay","Hourly", "Daily", "Weekly")
    var spinner: Spinner? = null
    val timepicker = CheckInTimeDialog()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_space)
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        this.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
        spinner = this.spinnerView
        spinnerView.onItemSelectedListener = this

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, timepick)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerView!!.adapter = adapter

        datePickerButton.setOnClickListener{
            checkRoomType()
        }
        nextButton.setOnClickListener {
                startActivity<BookingActivity>()
                finish()
        }
    }
    override fun onNothingSelected(adapterView: AdapterView<*>?) {
    }
    override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, p3: Long) {

    }
    fun checkRoomType() {
        when (spinnerView.selectedItem.toString()) {

            "Hourly" -> timepicker.show(this)
            "Day" -> datepicker.show(this, DatePickerType.SINGLE)
            "Week" -> datepicker.show(this, DatePickerType.RANGE)
            else -> datepicker.show(this, DatePickerType.MULTIPLE)
        }
    }
}




