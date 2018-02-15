package co.devpartners.devhub.api.events

import android.app.Activity
import android.app.Dialog
import android.view.Window
import android.widget.Button
import co.devpartners.devhub.R

/**
 * Created by DEVPARTNERS SOFTWARE on 2/9/2018.
 */
class CheckOutTimeDialog {
    lateinit var dialog : Dialog
    lateinit var select : Button
    fun show(activity: Activity){
        dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.checkout_layout)
        select = dialog.findViewById<Button>(R.id.selectCheckOutTime)

        select.setOnClickListener {
            dialog.hide()
        }
        dialog.show()
    }
}