package co.devpartners.devhub.events

import android.app.Activity
import android.app.Dialog
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.Window
import android.widget.Button
import co.devpartners.devhub.R

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

