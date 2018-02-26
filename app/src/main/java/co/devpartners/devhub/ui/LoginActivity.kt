package co.devpartners.devhub.ui


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import co.devpartners.devhub.R
import co.devpartners.devhub.api.service.Maps
import kotlinx.android.synthetic.main.activity_userlogin.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userlogin)
        supportActionBar?.hide()
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)


        locationText.setOnClickListener {
            startActivity<Maps>()
        }

        submitButton.setOnClickListener {
                startActivity<MainActivity>()
                finish()
        }
        createAccountTextView.setOnClickListener {
            startActivity<AccountRegisterActivity>()
        }
    }
}