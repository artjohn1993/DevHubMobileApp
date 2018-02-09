package co.devpartners.devhub.api.events

import android.app.Activity
import android.app.Dialog
import android.view.Window
import android.widget.Button
import co.devpartners.devhub.R

/**
 * Created by DEVPARTNERS SOFTWARE on 2/9/2018.
 */
class CheckInTimeDialog {
    lateinit var dialog : Dialog
    lateinit var select : Button
    fun show(activity: Activity){
        dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.checkin_layout)
        select = dialog.findViewById(R.id.selectCheckInTime)

        select.setOnClickListener {
            dialog.hide()
            CheckOutTimeDialog().show(activity)
        }
        dialog.show()
    }
}