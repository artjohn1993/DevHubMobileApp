package co.devpartners.devhub.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import co.devpartners.devhub.R
import com.fujiyuu75.sequent.Animation

import com.fujiyuu75.sequent.Sequent
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.startActivity


class RegisterActivity : AppCompatActivity() {


    lateinit var firstName:EditText
    lateinit var lastName:EditText
    lateinit var emailAddress:EditText
    lateinit var contactNumber:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()
        Sequent.origin(registerLayout).duration(400).anim(this, Animation.FADE_IN_LEFT).start()

          firstName = findViewById(R.id.firstnameEditText)
          lastName = findViewById(R.id.lastnameEditText)
          emailAddress = findViewById(R.id.emailEditText)
          contactNumber = findViewById(R.id.contactEditText)



        nextButton.setOnClickListener({

            Handler().postDelayed({
                startActivity<SpaceTypeActivity>()
                finish()
            },500)

//            var firstname: String = firstName.text.toString()
//            var lastname: String = lastName.text.toString()
//            var emailadd: String = emailAddress.text.toString()
//            var contact: String = contactNumber.text.toString()
//
//            val intent = Intent(applicationContext,BookingActivity::class.java)
//            intent.putExtra("FIRSTNAME",firstname)
//            intent.putExtra("LASTNAME",lastname)
//            intent.putExtra("EMAIL",emailadd)
//            intent.putExtra("CONTACT",contact)
//
//
//                startActivity(intent)

        })

    }
}
