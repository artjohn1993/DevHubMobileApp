package co.devpartners.devhub.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.devpartners.devhub.R
import co.devpartners.devhub.api.events.Success
import kotlinx.android.synthetic.main.activity_booking.*
import org.jetbrains.anko.startActivity

class BookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        reserveButton.setOnClickListener {
            startActivity<Success>()
        }
    }
}
