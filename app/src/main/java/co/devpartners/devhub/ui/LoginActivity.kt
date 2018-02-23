package co.devpartners.devhub.ui


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import co.devpartners.devhub.R
import co.devpartners.devhub.api.service.Maps
import kotlinx.android.synthetic.main.activity_userlogin.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {


    var fade_in : Animation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userlogin)
        supportActionBar?.hide()

        fade_in = AnimationUtils.loadAnimation(this,R.anim.fade_in)

        locationButton.setOnClickListener {
            startActivity<Maps>()
        }
        devHubLogo.animation = fade_in


        submitButton.setOnClickListener {
                startActivity<SpaceTypeActivity>()
                finish()
        }
        createAccountTextView.setOnClickListener {
            startActivity<AccountRegisterActivity>()
        }
    }
}