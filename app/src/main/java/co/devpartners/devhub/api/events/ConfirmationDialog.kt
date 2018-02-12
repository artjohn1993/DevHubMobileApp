package co.devpartners.devhub.api.events


import android.app.Activity
import android.app.Dialog
import android.support.v4.content.ContextCompat.startActivity
import android.view.Window
import android.widget.Button
import android.widget.Toast
import co.devpartners.devhub.R
import co.devpartners.devhub.ui.MainActivity
import java.util.logging.Handler
import org.jetbrains.anko.startActivity


/**
 * Created by Dev_03 on 2/12/2018.
 */
class ConfirmationDialog{
    lateinit var dialog : Dialog
    lateinit var select : Button
    lateinit var back : Button
    fun show(activity: Activity){
        dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.confirmation_layout)
        back = dialog.findViewById(R.id.backButton)
        select= dialog.findViewById(R.id.continueButton)


        back.setOnClickListener {
            dialog.hide()
        }
        select.setOnClickListener {
            dialog.hide()
            Success().show(activity)
        }
        dialog.show()


    }

}




