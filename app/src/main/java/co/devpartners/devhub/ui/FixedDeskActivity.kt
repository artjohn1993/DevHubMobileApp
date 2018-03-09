package co.devpartners.devhub.ui

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import co.devpartners.devhub.R
import co.devpartners.devhub.api.events.CheckInTimeDialog
import co.devpartners.devhub.api.events.CustomDatePickerDialog
import co.devpartners.devhub.api.model.DatePickerType
import kotlinx.android.synthetic.main.activity_fixed_desk.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.textColor

class FixedDeskActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    val datepicker = CustomDatePickerDialog()
    var timepick = arrayOf("Length of Stay","Hourly Package", "3-Hour Package", "Daily Package")
    var spinner: Spinner? = null
    val timepicker = CheckInTimeDialog()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fixed_desk)
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        this.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
        spinner = this.openSpaceDateSpinnerSchedule
        openSpaceDateSpinnerSchedule.onItemSelectedListener = this

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timepick)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        openSpaceDateSpinnerSchedule!!.adapter = adapter

        checkinTimeTextView.visibility = View.GONE
        checkoutTimeTextView.visibility = View.GONE

        openSpaceDatePickerButton.setOnClickListener{
            checkRoomType()
            showtext()

        }
        fixedDeskNextButton.setOnClickListener {
            Handler().postDelayed({
                startActivity<BookingActivity>()
                finish()
            },400)
        }
    }
    override fun onNothingSelected(adapterView: AdapterView<*>?) {
    }
    override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, p3: Long) {

    }
    fun checkRoomType() {
        when (openSpaceDateSpinnerSchedule.selectedItem.toString()) {
            "Length of Stay" -> Toast.makeText(this, "Please identify your length of stay.", Toast.LENGTH_SHORT).show()
            "Hourly Package" -> timepicker.show(this)
            "3-Hour Package" -> timepicker.show(this)
            "Daily Package" -> datepicker.show(this, DatePickerType.RANGE)
        }
        when(openSpaceDateSpinnerSchedule.selectedItem.toString()){
            "Length of Stay" -> openSpaceDatePickerButton.textColor = Color.RED
            "Hourly Package" ->  openSpaceDatePickerButton.textColor = Color.BLACK
            "3-Hour Package" -> openSpaceDatePickerButton.textColor = Color.BLACK
            "Daily Package" -> openSpaceDatePickerButton.textColor = Color.BLACK
        }
    }
    fun showtext() {
        when (openSpaceDateSpinnerSchedule.selectedItem.toString()) {
            "Hourly Package" -> checkinTimeTextView.visibility = View.VISIBLE
            "3-Hour Package" -> checkinTimeTextView.visibility = View.VISIBLE
        }
        when (openSpaceDateSpinnerSchedule.selectedItem.toString()) {
            "Hourly Package" -> checkoutTimeTextView.visibility = View.VISIBLE
            "3-Hour Package" -> checkoutTimeTextView.visibility = View.VISIBLE
        }
    }
}
