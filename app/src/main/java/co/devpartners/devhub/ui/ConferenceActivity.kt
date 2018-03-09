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
import co.devpartners.devhub.api.events.CheckInTimeDialog
import co.devpartners.devhub.api.events.CustomDatePickerDialog
import co.devpartners.devhub.api.model.DatePickerType
import kotlinx.android.synthetic.main.activity_conference.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.textColor
import org.jetbrains.anko.timePicker


class ConferenceActivity : AppCompatActivity() {
    val datepicker = CustomDatePickerDialog()
    val timepicker = CheckInTimeDialog()
    var roomType = arrayOf("Room Type","Conference","Meeting")
    var schedule = arrayOf("Pick a schedule","Week", "Day")

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
                Toast.makeText(this,"Please pick date schedule or week.", Toast.LENGTH_SHORT).show()
                datePickerButton1.textColor = Color.RED
            }
            "Week" ->{
                datepicker.show(this, DatePickerType.RANGE)
                datePickerButton1.textColor = Color.BLACK
            }
            "Day" ->{
                datepicker.show(this, DatePickerType.MULTIPLE)
                datePickerButton1.textColor = Color.BLACK
            }
        }

    }
}