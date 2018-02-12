package co.devpartners.devhub.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.devpartners.devhub.R
import com.fujiyuu75.sequent.Animation
import com.fujiyuu75.sequent.Direction
import com.fujiyuu75.sequent.Sequent
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()
        Sequent.origin(registerLayout).duration(500).anim(this, Animation.FADE_IN_LEFT).start()
        nextButton.setOnClickListener {
          startActivity<SpaceTypeActivity>()
        }
    }
}
