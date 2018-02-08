package co.devpartners.devhub.api.events

import android.app.Activity
import android.app.Dialog
import android.text.Selection
import android.view.Window
import android.widget.Button
import android.widget.CalendarView
import co.devpartners.devhub.R
import android.widget.TextView
import android.widget.Toast
import com.applikeysolutions.cosmocalendar.utils.SelectionType
import kotlinx.android.synthetic.main.activity_conference.*
import org.jetbrains.anko.selectedDateVerticalBarResource


/**
 * Created by DEVPARTNERS SOFTWARE on 2/7/2018.
 */
class CustomDatePickerDialog {
    lateinit var dialog : Dialog
    lateinit var cancel : Button
    lateinit var confirm : Button

    fun show(activity: Activity){

        dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.datepicker)

        cancel = dialog.findViewById(R.id.dialogCancelButton)
        confirm = dialog.findViewById(R.id.dialogConfirmButton)
        val calendar = dialog.findViewById<com.applikeysolutions.cosmocalendar.view.CalendarView>(R.id.calendar_view)
        calendar.setSelectionType(SelectionType.RANGE)
        cancel.setOnClickListener {
            dialog.hide()
        }
        confirm.setOnClickListener {
            dialog.hide()
          val something = calendar.selectedDates
            Toast.makeText(activity, "date $something", Toast.LENGTH_SHORT).show();
        }
        dialog.show()
    }
}

