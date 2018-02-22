package co.devpartners.devhub.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.Toast
import co.devpartners.devhub.R
import kotlinx.android.synthetic.main.activity_account_register.*
import org.jetbrains.anko.startActivity

class AccountRegisterActivity : AppCompatActivity() {

    var uptodown : Animation? = null
    var fade_in : Animation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_register)

        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown)
        fade_in = AnimationUtils.loadAnimation(this,R.anim.fade_in)

        devHubLogo.animation = uptodown
        bookNowText.animation = fade_in

        registerButton.setOnClickListener({

                Handler().postDelayed({
                    startActivity<SpaceTypeActivity>()
                    finish()
                }, 1400)
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