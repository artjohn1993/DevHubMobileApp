package co.devpartners.devhub.api.events

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.text.Selection
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.CalendarView
import co.devpartners.devhub.R
import android.widget.TextView
import android.widget.Toast
import co.devpartners.devhub.R.id.checkinDatePickerButton
import co.devpartners.devhub.api.model.DatePickerType
import co.devpartners.devhub.ui.OpenSpaceActivity
import com.applikeysolutions.cosmocalendar.utils.SelectionType
import kotlinx.android.synthetic.main.activity_conference.*
import kotlinx.android.synthetic.main.activity_open_space.*
import org.jetbrains.anko.selectedDateVerticalBarResource
import java.util.*


/**
 * Created by DEVPARTNERS SOFTWARE on 2/7/2018.
 */
class CustomDatePickerDialog : SelectDatePickerType(){
    lateinit var dialog : Dialog
    lateinit var cancel : Button
    lateinit var confirm : Button
    val checkin = CheckInTimeDialog()
    fun show(activity: Activity,type : DatePickerType){
        dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.datepicker)

        cancel = dialog.findViewById(R.id.dialogCancelButton)
        confirm = dialog.findViewById(R.id.dialogConfirmButton)
        val calendar = dialog.findViewById<com.applikeysolutions.cosmocalendar.view.CalendarView>(R.id.calendar_view)
        calendar.selectionType = select(type)

        cancel.setOnClickListener {
            dialog.hide()
        }
        confirm.setOnClickListener {
            val selectedDate = calendar.selectedDates
            dialog.hide()
            if (!selectedDate.isEmpty())
            checkin.show(activity)

            //Toast.makeText(activity, "date $something", Toast.LENGTH_SHORT).show()
        }
        dialog.show()
    }



}

