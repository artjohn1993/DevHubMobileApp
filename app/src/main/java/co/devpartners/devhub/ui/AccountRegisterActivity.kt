package co.devpartners.devhub.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.EditText
import android.widget.Toast
import co.devpartners.devhub.R
import kotlinx.android.synthetic.main.activity_account_register.*
import org.jetbrains.anko.startActivity

class AccountRegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_register)

        registerButton.setOnClickListener({

            if (isEditTextEmpty(firstnameEditText) || isEditTextEmpty(lastnameEditText) || isEditTextEmpty(usernameEditText) || isEditTextEmpty(contactEditText)) {

                if (isEditTextEmpty(firstnameEditText)) firstnameEditTextLayout.error = "Please fill up firstname"
                 if (isEditTextEmpty(lastnameEditText)) lastnameEditTextLayout.error = "Please fill up lastname"
                 if (isEditTextEmpty(usernameEditText)) emailEditTextLayout.error = "Please fill up email"
                 if (isEditTextEmpty(contactEditText)) contactEditTextLayout.error = "Please fill up contact number"
                 if (isEditTextEmpty(passwordEditText)) passwordEditTextLayout.error = "Please fill up password"
            } else {
                Handler().postDelayed({
                    Toast.makeText(this,"Account has been register.",Toast.LENGTH_SHORT).show()
                    startActivity<LoginActivity>()
                    finish()
                }, 1400)
            }
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
