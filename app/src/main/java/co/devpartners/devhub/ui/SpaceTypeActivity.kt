package co.devpartners.devhub.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import co.devpartners.devhub.R
import kotlinx.android.synthetic.main.activity_space_type.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.startActivity

class SpaceTypeActivity : AppCompatActivity() {
    companion object {
        var selectedSpace : ActivityType? = null
        var prevLayout : RelativeLayout? = null
        var preImage : ImageView? = null
    }

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_space_type)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
//        supportActionBar?.hide()

        this.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
        openSpaceLayout.setOnClickListener {
            selectedSpace = ActivityType.OpenSpaceActivity
            selected(openSpaceLayout,openSpaceImage)
        }
        privateSpaceLayout.setOnClickListener {
            selectedSpace = ActivityType.PrivateActivity
            selected(privateSpaceLayout,privateSpaceLogoImage)
        }
        conferenceSpaceLayout.setOnClickListener {
            selectedSpace = ActivityType.ConferenceActivity
            selected(conferenceSpaceLayout,conferenceSpaceLogoImage)
        }

        nextButton.setOnClickListener {
            nextPage()
        }

    }


    fun selected(layout : RelativeLayout? , image : ImageView?){

        if(preImage != null && prevLayout != null){
            preImage!!.setColorFilter(Color.argb(0, 255, 255, 255))
            prevLayout!!.setBackgroundResource(R.drawable.button_border)
        }

        preImage = image
        prevLayout = layout
        layout?.setBackgroundResource(R.color.colorPrimary)
        image?.setColorFilter(Color.argb(255, 255, 255, 255))
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
