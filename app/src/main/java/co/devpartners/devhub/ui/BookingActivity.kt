package co.devpartners.devhub.ui

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import co.devpartners.devhub.R
import kotlinx.android.synthetic.main.activity_booking.*
import org.jetbrains.anko.*
import com.gdacciaro.iOSDialog.iOSDialogBuilder



class BookingActivity : AppCompatActivity() {



    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        reserveButton.setOnClickListener {
            confirmDialog()
        }
    }

    fun confirmDialog() {
        reservedSucces()
    }

    @SuppressLint("WrongConstant")
    fun reservedSucces() {
        iOSDialogBuilder(this@BookingActivity)
                .setTitle("Booking Confirmation")
                .setSubtitle("Are you sure you want to be book in this space?")
                .setBoldPositiveLabel(true)
                .setCancelable(true)
                .setPositiveListener("CONFIRM") { dialog ->
                    dialog.dismiss()
                    startActivity<MainActivity>()
                    finish()
                    Toast.makeText(this@BookingActivity, "Reserved Successful!", Toast.LENGTH_LONG).show()
                }
                .setNegativeListener("GO BACK") { dialog ->
                    dialog.dismiss()
                }
                .build().show()
    }
}
