package co.devpartners.devhub.fragments


import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

import co.devpartners.devhub.R
import co.devpartners.devhub.api.events.CheckInTimeDialog
import co.devpartners.devhub.api.events.CustomDatePickerDialog
import co.devpartners.devhub.api.model.DatePickerType
import co.devpartners.devhub.ui.BookingActivity
import kotlinx.android.synthetic.main.activity_open_space.*
import kotlinx.android.synthetic.main.fragment_open.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.textColor


/**
 * A simple [Fragment] subclass.
 */
class OpenFragment : Fragment() {
    val datepicker = CustomDatePickerDialog()
    val timepicker = CheckInTimeDialog()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_open, container, false)
        val openDatePicker = view.findViewById<Button>(R.id.openDatePickerButton)
        val openNext = view.findViewById<Button>(R.id.openNextButton)
        openDatePicker.setOnClickListener {
            checkRoomType()
        }
        openNext.setOnClickListener {
            startActivity<BookingActivity>()
        }


        return view
    }
    fun checkRoomType() {
        when (openSpinnerSchedule.selectedItem.toString()) {
            "Length of Stay" -> Toast.makeText(this!!.activity!!, "Please identify your length of stay.", Toast.LENGTH_SHORT).show()
            "Hourly" -> timepicker.show(this!!.activity!!)
            "Day" -> datepicker.show(this!!.activity!!, DatePickerType.SINGLE)
            "Week" -> datepicker.show(this!!.activity!!, DatePickerType.RANGE)
            else -> datepicker.show(this!!.activity!!, DatePickerType.MULTIPLE)
        }
        when(openSpinnerSchedule.selectedItem.toString()){
            "Length of Stay" -> openDatePickerButton.textColor = Color.RED
            "Day" ->  openDatePickerButton.textColor = Color.BLACK
            "Week" -> openDatePickerButton.textColor = Color.BLACK
            "Hourly" -> openDatePickerButton.textColor = Color.BLACK
        }
    }

}
