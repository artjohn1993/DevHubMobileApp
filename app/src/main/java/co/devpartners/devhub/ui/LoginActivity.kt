package co.devpartners.devhub.ui


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.Visibility
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import co.devpartners.devhub.R
import co.devpartners.devhub.R.layout.activity_userlogin
import co.devpartners.devhub.api.events.MapsActivity
import kotlinx.android.synthetic.main.activity_userlogin.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    var uptodown : Animation? = null
    var fade_in : Animation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_userlogin)
        supportActionBar?.hide()

        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown)
        fade_in = AnimationUtils.loadAnimation(this,R.anim.fade_in)

        locationButton.setOnClickListener {
            startActivity<MapsActivity>()
        }
        devHubLogo.animation = uptodown
        loginLayout.animation = fade_in

        submitButton.setOnClickListener {
                startActivity<SpaceTypeActivity>()
                finish()
        }
        createAccountTextView.setOnClickListener {
            startActivity<AccountRegisterActivity>()
        }
    }
}