package co.devpartners.devhub.ui

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
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

        val firstnameText = findViewById<TextView>(R.id.firstnameTextView)
        firstnameText.text = " $firstname $lastname"
        val emailaddText = findViewById<TextView>(R.id.emailTextView)
        emailaddText.text = " $emailadd"
        val contactText = findViewById<TextView>(R.id.contactTextView)
        contactText.text = " $contact"

        reserveButton.setOnClickListener {
            Handler().postDelayed({
                confirmDialog()
            },400)

        }
    }
    fun confirmDialog() {
        confirm.show(this)
    }
}
