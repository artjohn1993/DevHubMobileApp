package co.devpartners.devhub.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import co.devpartners.devhub.R
import kotlinx.android.synthetic.main.activity_space_type.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.startActivity
import com.basel.DualButton.DualButton



class SpaceTypeActivity : AppCompatActivity() {
    companion object {
        var selectedSpace : ActivityType? = null
        var prevButton : com.basel.DualButton.DualButton? = null
        var preImage : ImageView? = null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_space_type)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
//        supportActionBar?.hide()
        this.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)

        openSpace.setDualClickListener(object : DualButton.OnDualClickListener {
            override fun onClickFirst(btn: Button) {
                switch(openSpace)
                selectedSpace = ActivityType.OpenSpaceActivity

            }

            override fun onClickSecond(btn: Button) {
                setNull()
            }
        })
        privateSpace.setDualClickListener(object : DualButton.OnDualClickListener {
            override fun onClickFirst(btn: Button) {
                switch(privateSpace)
                selectedSpace = ActivityType.PrivateActivity
            }

            override fun onClickSecond(btn: Button) {
                setNull()
            }
        })
        nextButton.setOnClickListener {
            nextPage()
        }
        conferenceSpace.setDualClickListener(object : DualButton.OnDualClickListener {
            override fun onClickFirst(btn: Button) {
                switch(conferenceSpace)
                selectedSpace = ActivityType.ConferenceActivity
            }
            override fun onClickSecond(btn: Button) {
                setNull()
            }
        })
        nextButton.setOnClickListener {
            nextPage()
        }
    }
    fun switch(prev : com.basel.DualButton.DualButton){
        if(prevButton == null){
            prevButton = prev
        }
        else{
            prevButton!!.onClicked()
            prevButton = prev
        }
    }
    fun setNull(){
        prevButton = null
        selectedSpace = null
    }
    fun nextPage(){
        when(selectedSpace){
            ActivityType.OpenSpaceActivity -> {
                startActivity<OpenSpaceActivity>()
            }
            ActivityType.ConferenceActivity ->{
                startActivity<ConferenceActivity>()
            }
            ActivityType.PrivateActivity -> {
                startActivity<PrivateSpaceActivity>()

            }
            null -> {
                alert("Please confirm space type"){
                    title = "Information"
                }.show()
            }
        }
    }
    enum class ActivityType{
        OpenSpaceActivity,
        PrivateActivity,
        ConferenceActivity
    }
}
