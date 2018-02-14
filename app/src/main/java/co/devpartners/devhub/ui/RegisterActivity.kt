package co.devpartners.devhub.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import co.devpartners.devhub.R
import com.fujiyuu75.sequent.Animation

import com.fujiyuu75.sequent.Sequent
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.startActivity


class RegisterActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()
        Sequent.origin(registerLayout).duration(500).anim(this, Animation.FADE_IN_LEFT).start()

         var firstName = findViewById<EditText>(R.id.firstnameEditText)
         var lastName = findViewById<EditText>(R.id.lastnameEditText)
         var emailAddress = findViewById<EditText>(R.id.emailEditText)
         var contactNumber = findViewById<EditText>(R.id.emailEditText)

        var save = findViewById<Button>(R.id.nextButton)

        save.setOnClickListener({
            var firstname = firstName.text.toString()
            var lastname = lastName.text.toString()
            var emailadd = emailAddress.text.toString()
            var contact = contactNumber.text.toString()

            val intent = Intent(this,BookingActivity::class.java)
            intent.putExtra("FIRSTNAME",firstname)
            intent.putExtra("LASTNAME",lastname)
            intent.putExtra("EMAIL",emailadd)
            intent.putExtra("CONTACT",contact)

            startActivity<SpaceTypeActivity>()

        })
    }
}
