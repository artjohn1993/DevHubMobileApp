package co.devpartners.devhub.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import co.devpartners.devhub.R
import com.fujiyuu75.sequent.Animation
import com.fujiyuu75.sequent.Sequent
import kotlinx.android.synthetic.main.activity_account_register.*
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
        Sequent.origin(splashLayout).duration(400).start()
        Handler().postDelayed({
            startActivity<LoginActivity>()
            finish()
        },3000)
    }
}