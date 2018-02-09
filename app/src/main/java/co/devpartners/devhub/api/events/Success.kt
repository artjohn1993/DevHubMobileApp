package co.devpartners.devhub.api.events

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import co.devpartners.devhub.R
import co.devpartners.devhub.ui.MainActivity
import org.jetbrains.anko.startActivity


/**
 * Created by Dev_03 on 2/9/2018.
 */
class Success : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.success_layout)

        supportActionBar?.hide()

        Handler().postDelayed({
            startActivity<MainActivity>()
            finish()
        },3000)

    }

}