package co.devpartners.devhub.ui

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import co.devpartners.devhub.R
import co.devpartners.devhub.api.events.ConfirmationDialog
import kotlinx.android.synthetic.main.activity_booking.*
import org.jetbrains.anko.startActivity

class BookingActivity : AppCompatActivity() {



    val confirm = ConfirmationDialog()
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        val intentObject = intent

        val firstname = intentObject.getStringExtra("FIRSTNAME")
        val lastname = intentObject.getStringExtra("LASTNAME")
        val emailadd = intentObject.getStringExtra("EMAIL")
        val contact = intentObject.getStringExtra("CONTACT")
        val spaceType = intentObject.getStringExtra("SPACE")
        val rate = intentObject.getStringExtra("RATE")
        val guests = intentObject.getStringExtra("GUESTS")
        val period = intentObject.getStringExtra("PERIOD")
        val bill = intentObject.getStringExtra("BILL")
        val message = intentObject.getStringExtra("MESSAGE")

        nameReservedText.text = "Name : $firstname $lastname"
        numberReservedText.text = "Contact Number : $contact"
        emailReservedText.text = "Email : $emailadd"
        spaceTypeReservedText.text = "Space : $spaceType"
        rateReservedText.text = "Rate : $rate"
        numberGuestReservedText.text = "Number of Guests: $guests"
        periodReservedText.text = "Period : $period"
        billReservedText.text = "Bill : $bill"
        messageReservedText.text = "Message : $message"

        reserveButton.setOnClickListener {
            showSuccess()
        }
    }
    fun confirmDialog() {
        confirm.show(this)
    }
    fun showSuccess(){
        val snackbar : Snackbar = Snackbar.make(findViewById(android.R.id.content),"Reserved",Snackbar.LENGTH_LONG)
        snackbar.setAction(R.string.confirm_summary,View.OnClickListener { backToMain() })
        val snackView = snackbar.view
        snackView.setBackgroundColor(this.resources.getColor(R.color.colorSuccess))
        snackbar.show()
    }
    fun backToMain(){
        startActivity<MainActivity>()
        Toast.makeText(this,"Reserved Successful!",Toast.LENGTH_LONG).show()
        finish()
    }
}