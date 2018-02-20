package co.devpartners.devhub.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
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
        Sequent.origin(registerLayout).duration(400).anim(this, Animation.FADE_IN_LEFT).start()
        this.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)


        nextButton.setOnClickListener({

            if(isEditTextEmpty(firstnameEditText) || isEditTextEmpty(lastnameEditText) || isEditTextEmpty(usernameEditText) || isEditTextEmpty(contactEditText)) {

                if (isEditTextEmpty(firstnameEditText)) firstnameEditTextLayout.error = "Please fill up firstname"
                else if (isEditTextEmpty(lastnameEditText)) lastnameEditTextLayout.error = "Please fill up lastname"
                else if (isEditTextEmpty(usernameEditText)) emailEditTextLayout.error = "Please fill up email"
                else if (isEditTextEmpty(contactEditText)) contactEditTextLayout.error = "Please fill up contact number"
            }
            else{
                Handler().postDelayed({
                    startActivity<SpaceTypeActivity>()
                },400)
            }


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
    fun isEditTextEmpty(text : EditText) : Boolean{
        if(text.text.toString() == "") return true
        else{
            firstnameEditTextLayout.error = null
            lastnameEditTextLayout.error = null
            emailEditTextLayout.error = null
            contactEditTextLayout.error = null
            return false
        }
    }
}


