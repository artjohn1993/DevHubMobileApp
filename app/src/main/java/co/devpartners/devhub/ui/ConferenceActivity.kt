package co.devpartners.devhub.ui

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.ArrayAdapter
import co.devpartners.devhub.R
import co.devpartners.devhub.api.events.CustomDatePickerDialog
import kotlinx.android.synthetic.main.activity_conference.*
import kotlinx.android.synthetic.main.datepicker.*


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
                    datepicker.show(this)
        }


    }



}
