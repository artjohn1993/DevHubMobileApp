package co.devpartners.devhub.ui

import android.annotation.TargetApi
import android.app.TimePickerDialog
import android.graphics.Color
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
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
import kotlinx.android.synthetic.main.activity_private_space.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.textColor


class PrivateSpaceActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener{

    val datepicker = CustomDatePickerDialog()
    var timepick = arrayOf("Length of Stay","Hourly Package", "3-Hour Package", "Daily Package")
    var spinner: Spinner? = null
    val timepicker = CheckInTimeDialog()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_private_space)
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        this.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
        spinner = this.privateSchedule
        privateSchedule.onItemSelectedListener = this

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timepick)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        privateSchedule!!.adapter = adapter

        checkinTimeTextView.visibility = View.GONE
//        checkoutTimeTextView.visibility = View.GONE

        privateDatePickerButton.setOnClickListener{
            checkRoomType()
            showText()
            checkintime()
        }
        privateNextButton.setOnClickListener {
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
        when (privateSchedule.selectedItem.toString()) {

            "Length of Stay" -> Toast.makeText(this, "Please identify your length of stay.",Toast.LENGTH_SHORT).show()
//            "Hourly Package" -> timepicker.show(this)
//            "3-Hour Package" -> timepicker.show(this)
            "Daily Package" -> datepicker.show(this, DatePickerType.RANGE)

        }
        when(privateSchedule.selectedItem.toString()){
            "Length of Stay" -> privateDatePickerButton.textColor = Color.RED
            "Hourly Package" ->  privateDatePickerButton.textColor = Color.BLACK
            "3-Hour Package" -> privateDatePickerButton.textColor = Color.BLACK
            "Daily Package" -> privateDatePickerButton.textColor = Color.BLACK
        }
    }
    fun showText(){
        when(privateSchedule.selectedItem.toString()){
            "Hourly Package" -> checkinTimeTextView.visibility = View.VISIBLE
            "3-Hour Package" -> checkinTimeTextView.visibility = View.VISIBLE
        }
//        when(privateSchedule.selectedItem.toString()){
//            "Hourly Package" -> checkoutTimeTextView.visibility = View.VISIBLE
//            "3-Hour Package" -> checkoutTimeTextView.visibility = View.VISIBLE
//        }

    }
    @TargetApi(Build.VERSION_CODES.N)
    fun checkintime() {
        val cal = Calendar.getInstance()

        val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)

            var AM_PM: String
            if(hour < 12){
                AM_PM = " AM"
            }else{
                AM_PM =" PM"
            }

            checkinTimeTextView.text = "Check in time "+ SimpleDateFormat("HH:mm").format(cal.time)+AM_PM
        }
        when (privateSchedule.selectedItem.toString()) {
            "Length of Stay" -> Toast.makeText(this, "Please identify your length of stay.",Toast.LENGTH_SHORT).show()
            "Hourly Package" -> TimePickerDialog(this,R.style.TimePickerTheme, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), false).show()
            "3-Hour Package" -> TimePickerDialog(this,R.style.TimePickerTheme, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), false).show()
        }

    }
}