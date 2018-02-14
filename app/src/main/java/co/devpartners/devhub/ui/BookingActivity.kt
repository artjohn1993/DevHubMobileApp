package co.devpartners.devhub.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import co.devpartners.devhub.R
import co.devpartners.devhub.api.events.ConfirmationDialog
import kotlinx.android.synthetic.main.activity_booking.*

class BookingActivity : AppCompatActivity() {

    internal var firstName: String? = null
    internal var lastName: String? = null
    internal var emailAdd: String? = null
    internal var contact: String? = null

    val confirm = ConfirmationDialog()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        firstName = intent.getStringExtra("FIRSTNAME")
        lastName = intent.getStringExtra("LASTNAME")
        emailAdd = intent.getStringExtra("EMAIL")
        contact = intent.getStringExtra("CONTACT")

        val firstnameText = findViewById<TextView>(R.id.firstnameTextView)
        firstnameText.text = ""+firstName
        val lastnameText = findViewById<TextView>(R.id.lastnameTextView)
        lastnameText.text = ""+lastName
        val emailaddText = findViewById<TextView>(R.id.emailTextView)
        emailaddText.text = ""+emailAdd
        val contactText = findViewById<TextView>(R.id.contactTextView)
        contactText.text = ""+contact

        reserveButton.setOnClickListener {
            confirmDialog()
        }
    }
    fun confirmDialog() {
        confirm.show(this)
    }
}
