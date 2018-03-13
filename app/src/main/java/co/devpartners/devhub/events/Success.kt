package co.devpartners.devhub.events

import android.app.Activity
import android.app.Dialog
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.Window
import co.devpartners.devhub.R
import co.devpartners.devhub.ui.MainActivity
import org.jetbrains.anko.startActivity


/**
 * Created by Dev_03 on 2/9/2018.
 */
class Success: AppCompatActivity() {
    lateinit var dialog: Dialog
    fun show(activity: Activity) {
        dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.success_layout)


        dialog.show()

        Handler().postDelayed({
            dialog.hide()
            startActivity<MainActivity>()
            finish()
        }, 2500)
    }
}
