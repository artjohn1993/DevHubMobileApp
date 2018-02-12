package co.devpartners.devhub.api.events

import android.app.Activity
import android.app.Dialog
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.widget.Button
import co.devpartners.devhub.R
import kotlinx.android.synthetic.main.activity_booking.*


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
            finish()
        }, 2500)


    }


        /*: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.success_layout)

        supportActionBar?.hide()
            Handler().postDelayed({
                startActivity<MainActivity>()
                finish()
            },3000)

        }*/
    }
