package co.devpartners.devhub.events

import android.app.Activity
import android.app.Dialog
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.Window
import android.widget.Button
import co.devpartners.devhub.R
import co.devpartners.devhub.model.DatePickerType


/**
 * Created by DEVPARTNERS SOFTWARE on 2/7/2018.
 */
class CustomDatePickerDialog : SelectDatePickerType(){
    lateinit var dialog : Dialog
    lateinit var cancel : Button
    lateinit var confirm : Button
    val checkin = CheckInTimeDialog()
    @RequiresApi(Build.VERSION_CODES.N)
    fun show(activity: Activity, type : DatePickerType){
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

