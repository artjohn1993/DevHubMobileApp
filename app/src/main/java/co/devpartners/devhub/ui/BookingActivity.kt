package co.devpartners.devhub.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.devpartners.devhub.R
import co.devpartners.devhub.api.events.ConfirmationDialog
import co.devpartners.devhub.api.events.Success
import kotlinx.android.synthetic.main.activity_booking.*
import kotlinx.android.synthetic.main.confirmation_layout.*

class BookingActivity : AppCompatActivity() {

    val failure = Success()
    val confirm = ConfirmationDialog()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        reserveButton.setOnClickListener {
            confirmDialog()

        }
    }
    fun confirmDialog() {
        confirm.show(this)
    }
}
