package co.devpartners.devhub.ui

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.ArrayAdapter
import co.devpartners.devhub.R
import co.devpartners.devhub.api.events.CustomDatePickerDialog
import co.devpartners.devhub.api.model.DatePickerType
import kotlinx.android.synthetic.main.activity_conference.*
import kotlinx.android.synthetic.main.datepicker.*
import org.jetbrains.anko.alert


class ConferenceActivity : AppCompatActivity() {
    val datepicker = CustomDatePickerDialog()
    var roomType = arrayOf("Conference","Meeting")
    var schedule = arrayOf("Day","Week")

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conference)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val adapterRoomType : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1,roomType)
        val adapterSchedule : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1,schedule)
        roomTypeSpinner.adapter = adapterRoomType
        scheduleSpinner.adapter = adapterSchedule

        datePickerButton.setOnClickListener{
            checkRoomType()
        }


    }
    fun checkRoomType(){
        when(scheduleSpinner.selectedItem.toString()){
            "Day" -> datepicker.show(this,DatePickerType.SINGLE)
            "Week" -> datepicker.show(this,DatePickerType.RANGE)
            else -> datepicker.show(this,DatePickerType.MULTIPLE)
        }

    }

}
