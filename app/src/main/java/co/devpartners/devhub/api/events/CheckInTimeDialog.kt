package co.devpartners.devhub.api.events

import android.app.Activity
import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.View
import android.view.Window
import android.widget.Button
import co.devpartners.devhub.R
import co.devpartners.devhub.R.id.checkinTimePicker
import co.devpartners.devhub.ui.OpenSpaceActivity
import kotlinx.android.synthetic.main.activity_open_space.*
/**
 * Created by DEVPARTNERS SOFTWARE on 2/9/2018.
 */
class CheckInTimeDialog {
    lateinit var dialog: Dialog
    lateinit var select: Button
    @RequiresApi(Build.VERSION_CODES.N)
//    val checkout = CheckOutTimeDialog()
    fun show(activity: Activity) {
        dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.checkin_layout)
        select = dialog.findViewById<Button>(R.id.selectCheckInTime)

        select.setOnClickListener {
            dialog.hide()
        }
        dialog.show()
    }
}
//    @RequiresApi(Build.VERSION_CODES.N)
//    fun checkintime(view: View) {
//        val cal = Calendar.getInstance()
//        TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
//            cal.set(Calendar.HOUR_OF_DAY, hour)
//            cal.set(Calendar.MINUTE, minute)
//
//            var AM_PM: String
//            if (hour < 12) {
//                AM_PM = "AM"
//            } else {
//                AM_PM = "PM"
//            }
//            chalala!!.checkinTimeTextView.text = SimpleDateFormat("HH:mm").format(cal.time) + AM_PM
//        }
//
//    }
