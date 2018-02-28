package co.devpartners.devhub.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import co.devpartners.devhub.R
import kotlinx.android.synthetic.main.activity_space_services.*

import org.jetbrains.anko.startActivity

class SpaceServices : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_space_services)
        supportActionBar?.hide()
        openSpaceCardView.setOnClickListener {
            startActivity<SpaceTypeActivity>()
        }
        privateSpaceCardView.setOnClickListener {
            startActivity<SpaceTypeActivity>()
        }
        fixedDeskCardView.setOnClickListener {
            Toast.makeText(this,"no design yet",Toast.LENGTH_SHORT).show()
        }
        conferenceCardView.setOnClickListener {
            startActivity<SpaceTypeActivity>()
        }
    }
}
