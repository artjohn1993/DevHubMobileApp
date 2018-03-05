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
            startActivity<OpenSpaceActivity>()
        }
        privateSpaceCardView.setOnClickListener {
            startActivity<PrivateSpaceActivity>()
        }
        fixedDeskCardView.setOnClickListener {
            startActivity<FixedDeskActivity>()
        }
        conferenceCardView.setOnClickListener {
            startActivity<ConferenceActivity>()
        }
        meetingRoomCardView.setOnClickListener {
            startActivity<MeetingActivity>()
        }
    }
}
