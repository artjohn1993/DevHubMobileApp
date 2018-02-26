package co.devpartners.devhub.fragments


import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

import co.devpartners.devhub.R
import co.devpartners.devhub.api.events.CheckInTimeDialog
import co.devpartners.devhub.api.events.CustomDatePickerDialog
import co.devpartners.devhub.api.model.DatePickerType
import co.devpartners.devhub.ui.BookingActivity
import kotlinx.android.synthetic.main.activity_private_space.*
import kotlinx.android.synthetic.main.fragment_private.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.textColor
import java.text.Normalizer


/**
 * A simple [Fragment] subclass.
 */
class PrivateFragment : Fragment() {

    val datepicker = CustomDatePickerDialog()
    val timepicker = CheckInTimeDialog()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view  = inflater.inflate(R.layout.fragment_private, container, false)
        val privateNextButton = view.findViewById<TextView>(R.id.privateNextButton)
        val privateSchedule = view.findViewById<Button>(R.id.privateDatePickerButton)

        privateSchedule.setOnClickListener {
            checkRoomType()
        }
        privateNextButton.setOnClickListener {
            startActivity<BookingActivity>()
        }

        return view
    }
    fun checkRoomType() {
        when (privateSchedule.selectedItem.toString()) {
            "Pick a Schedule" -> Toast.makeText(this!!.activity!!, "Please identify your length of stay.", Toast.LENGTH_SHORT).show()
            "Length of Stay" -> Toast.makeText(this!!.activity!!, "Please identify your length of stay.", Toast.LENGTH_SHORT).show()
            "Hourly" -> timepicker.show(this!!.activity!!)
            "Day" -> datepicker.show(this!!.activity!!, DatePickerType.SINGLE)
            "Week" -> datepicker.show(this!!.activity!!, DatePickerType.RANGE)
        }
        when(privateSchedule.selectedItem.toString()){
            "Pick a Schedule" -> privateDatePickerButton.textColor = Color.RED
            "Day" ->  privateDatePickerButton.textColor = Color.BLACK
            "Week" -> privateDatePickerButton.textColor = Color.BLACK
            "Hourly" -> privateDatePickerButton.textColor = Color.BLACK
        }
    }
}
