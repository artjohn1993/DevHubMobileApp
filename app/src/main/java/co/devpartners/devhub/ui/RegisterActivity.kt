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




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()
        Sequent.origin(registerLayout).duration(400).anim(this, Animation.FADE_IN_LEFT).start()


        nextButton.setOnClickListener({

            Handler().postDelayed({
                startActivity<SpaceTypeActivity>()
            },400)

//            val firstname: String = firstnameEditText.text.toString()
//            val lastname: String = lastnameEditText.text.toString()
//            val emailadd: String = emailEditText.text.toString()
//            val contact: String = contactEditText.text.toString()
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
