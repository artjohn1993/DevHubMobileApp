package co.devpartners.devhub.fragments


import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import co.devpartners.devhub.R
import co.devpartners.devhub.api.events.CheckInTimeDialog
import co.devpartners.devhub.api.events.CustomDatePickerDialog
import co.devpartners.devhub.api.model.DatePickerType
import co.devpartners.devhub.ui.BookingActivity
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
        val openDatePicker = view.findViewById<TextView>(R.id.fixedDeskDatePickerButton)
        val openNext = view.findViewById<Button>(R.id.fixedDeskNextButton)

        val checkinText = view!!.findViewById<TextView>(R.id.checkinTimeTextView)
        val checkoutText = view!!.findViewById<TextView>(R.id.checkoutTimeTextView)

        checkinText.visibility = GONE
        checkoutText.visibility = GONE

        openDatePicker.setOnClickListener {
            checkRoomType()
            showtext()

        }
        openNext.setOnClickListener {
            startActivity<BookingActivity>()
        }


        return view
    }

    fun checkRoomType() {

        when (fixedDeskDateSpinnerSchedule.selectedItem.toString()) {
            "Pick a Schedule" -> Toast.makeText(this!!.activity!!, "Please identify your length of stay.", Toast.LENGTH_SHORT).show()
            "Hourly" -> timepicker.show(this!!.activity!!)
            "Daily" -> datepicker.show(this!!.activity!!, DatePickerType.SINGLE)
            "Weekly" -> datepicker.show(this!!.activity!!, DatePickerType.RANGE)
            else -> datepicker.show(this.activity!!, DatePickerType.SINGLE)
        }

        when (fixedDeskDateSpinnerSchedule.selectedItem.toString()) {
            "Pick a Schedule" -> fixedDeskDatePickerButton.textColor = Color.RED
            "Daily" -> fixedDeskDatePickerButton.textColor = Color.RED
            "Weekly" -> fixedDeskDatePickerButton.textColor = Color.RED
            "Hourly" -> fixedDeskDatePickerButton.textColor = Color.BLACK

        }
    }

    fun showtext() {
        val checkinText = view!!.findViewById<TextView>(R.id.checkinTimeTextView)
        val checkoutText = view!!.findViewById<TextView>(R.id.checkoutTimeTextView)

        when (fixedDeskDateSpinnerSchedule.selectedItem.toString()) {
            "Hourly" -> checkinText.visibility = VISIBLE
        }
        when (fixedDeskDateSpinnerSchedule.selectedItem.toString()) {
            "Hourly" -> checkoutText.visibility = VISIBLE
        }
    }

}