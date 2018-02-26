package co.devpartners.devhub.fragments


import android.annotation.SuppressLint
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
import kotlinx.android.synthetic.main.activity_conference.*
import kotlinx.android.synthetic.main.fragment_conference.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.textColor


class ConferenceFragment : Fragment() {
    val datepicker = CustomDatePickerDialog()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_conference, container, false)
       val btn = view.findViewById<Button>(R.id.datePickerButton1)
        val next = view.findViewById<Button>(R.id.conferenceNextButtton1)


        btn.setOnClickListener {
            checkRoomType()
        }
        next.setOnClickListener {
            startActivity<BookingActivity>()

        }

        return view
    }
    @SuppressLint("ResourceAsColor")
    fun checkRoomType(){
        when(scheduleSpinner1.selectedItem.toString()){
            "Pick a schedule" -> {
                Toast.makeText(this!!.activity!!,"Please pick date schedule or week.", Toast.LENGTH_SHORT).show()
                datePickerButton1.textColor = Color.RED
            }
            "Day" ->{
                datepicker.show(this!!.activity!!,DatePickerType.SINGLE)
                datePickerButton1.textColor = Color.BLACK
            }
            "Week" ->{
                datepicker.show(this!!.activity!!,DatePickerType.RANGE)
                datePickerButton1.textColor = Color.BLACK
            }
            else -> datepicker.show(this!!.activity!!,DatePickerType.MULTIPLE)
        }

    }


}
