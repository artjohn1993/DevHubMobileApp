package co.devpartners.devhub.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.annotation.RequiresApi
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import co.devpartners.devhub.R
import co.devpartners.devhub.api.events.CustomDatePickerDialog
import co.devpartners.devhub.api.model.DatePickerType
import kotlinx.android.synthetic.main.activity_conference.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.textColor


class ConferenceActivity : AppCompatActivity() {
    val datepicker = CustomDatePickerDialog()
    var roomType = arrayOf("Room Type","Conference","Meeting")
    var schedule = arrayOf("Pick a schedule","Day","Week")

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conference)
        this.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val adapterRoomType : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1,roomType)
        val adapterSchedule : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1,schedule)
        roomTypeSpinner.adapter = adapterRoomType
        scheduleSpinner.adapter = adapterSchedule

        datePickerButton.setOnClickListener {
            checkRoomType()
        }

        conferenceNextButtton.setOnClickListener {
            Handler().postDelayed({
                startActivity<BookingActivity>()
                finish()
            },400)
        }
    }

    @SuppressLint("ResourceAsColor")
    fun checkRoomType(){
        when(scheduleSpinner.selectedItem.toString()){
            "Pick a schedule" -> Toast.makeText(this,"Please pick date schedule or week.",Toast.LENGTH_SHORT).show()
            "Day" -> datepicker.show(this,DatePickerType.SINGLE)
            "Week" -> datepicker.show(this,DatePickerType.RANGE)
            else -> datepicker.show(this,DatePickerType.MULTIPLE)
        }
        when(scheduleSpinner.selectedItem.toString()){
            "Pick a schedule" -> datePickerButton.textColor = Color.RED
            "Day" ->  datePickerButton.textColor = Color.BLACK
            "Week" -> datePickerButton.textColor = Color.BLACK
        }
    }
}