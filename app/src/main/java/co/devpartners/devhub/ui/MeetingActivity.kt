package co.devpartners.devhub.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Toast
import co.devpartners.devhub.R
import co.devpartners.devhub.api.events.CustomDatePickerDialog
import co.devpartners.devhub.api.model.DatePickerType
import kotlinx.android.synthetic.main.activity_meeting.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.textColor

class MeetingActivity : AppCompatActivity() {
    val datepicker = CustomDatePickerDialog()
    var roomType = arrayOf("Room Type","Conference","Meeting")
    var schedule = arrayOf("Pick a schedule","Day","Week")

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meeting)
        this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val adapterRoomType : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, roomType)
        val adapterSchedule : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, schedule)
        roomTypeSpinner1.adapter = adapterRoomType
        scheduleSpinner1.adapter = adapterSchedule

        datePickerButton1.setOnClickListener {
            checkRoomType()
        }

        conferenceButton1.setOnClickListener {
            Handler().postDelayed({
                startActivity<BookingActivity>()
                finish()
            },400)
        }
    }

    @SuppressLint("ResourceAsColor")
    fun checkRoomType(){
        when(scheduleSpinner1.selectedItem.toString()){
            "Pick a schedule" -> {
                Toast.makeText(this, "Please pick date schedule or week.", Toast.LENGTH_SHORT).show()
                datePickerButton1.textColor = Color.RED
            }
            "Day" ->{
                datepicker.show(this, DatePickerType.SINGLE)
                datePickerButton1.textColor = Color.BLACK
            }
            "Week" ->{
                datepicker.show(this, DatePickerType.RANGE)
                datePickerButton1.textColor = Color.BLACK
            }
            else -> datepicker.show(this, DatePickerType.MULTIPLE)
        }

    }
}