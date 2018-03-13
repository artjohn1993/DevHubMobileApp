package co.devpartners.devhub.fragments


import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import co.devpartners.devhub.R
import co.devpartners.devhub.events.CheckInTimeDialog
import co.devpartners.devhub.events.CustomDatePickerDialog
import co.devpartners.devhub.model.DatePickerType
import co.devpartners.devhub.ui.BookingActivity
import kotlinx.android.synthetic.main.fragment_private.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.textColor


/**
 * A simple [Fragment] subclass.
 */
class PrivateFragment : Fragment() {

    val datepicker = CustomDatePickerDialog()
    val timepicker = CheckInTimeDialog()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view  = inflater.inflate(R.layout.fragment_private, container, false)
        val privateNextButton = view.findViewById<Button>(R.id.privateNextButton)
        val privateSchedule = view.findViewById<TextView>(R.id.privateDatePickerButton)
        val checkinText = view.findViewById<TextView>(R.id.checkinTimeTextView)
        val checkoutText = view.findViewById<TextView>(R.id.checkoutTimeTextView)
        checkinText.visibility = View.GONE
        checkoutText.visibility = View.GONE

        privateSchedule.setOnClickListener {
            checkRoomType()
            showText()
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
            "Daily" -> datepicker.show(this!!.activity!!, DatePickerType.SINGLE)
            "Weekly" -> datepicker.show(this!!.activity!!, DatePickerType.RANGE)
        }
        when(privateSchedule.selectedItem.toString()){
            "Pick a Schedule" -> privateDatePickerButton.textColor = Color.RED
            "Daily" ->  privateDatePickerButton.textColor = Color.RED
            "Weekly" -> privateDatePickerButton.textColor = Color.RED
            "Hourly" -> privateDatePickerButton.textColor = Color.BLACK
        }
    }
    fun showText(){
        val checkinText = view!!.findViewById<TextView>(R.id.checkinTimeTextView)
        val checkoutText = view!!.findViewById<TextView>(R.id.checkoutTimeTextView)
        when(privateSchedule.selectedItem.toString()){
            "Hourly" -> checkinText.visibility = View.VISIBLE
        }
        when(privateSchedule.selectedItem.toString()){
            "Hourly" -> checkoutText.visibility = View.VISIBLE
        }

    }
}
