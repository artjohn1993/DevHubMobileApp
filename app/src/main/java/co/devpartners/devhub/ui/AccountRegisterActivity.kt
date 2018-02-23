package co.devpartners.devhub.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.Toast
import co.devpartners.devhub.R
import com.fujiyuu75.sequent.Direction
import com.fujiyuu75.sequent.Sequent
import kotlinx.android.synthetic.main.activity_account_register.*
import org.jetbrains.anko.startActivity

class AccountRegisterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_register)
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

        Sequent.origin(registerLayout).duration(400).anim(this,com.fujiyuu75.sequent.Animation.FADE_IN_LEFT).start()

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