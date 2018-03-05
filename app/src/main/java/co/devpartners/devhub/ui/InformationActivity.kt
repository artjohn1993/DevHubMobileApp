package co.devpartners.devhub.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import co.devpartners.devhub.R
import co.devpartners.devhub.api.model.Adapter.FeedbackPageAdapter
import co.devpartners.devhub.fragments.BillingFragment
import co.devpartners.devhub.fragments.FeedbackFragment
import kotlinx.android.synthetic.main.activity_information.*


class InformationActivity : AppCompatActivity() {

    private  val pager = FeedbackFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)
        title = "Information"

        setupViewPager(containerFeedback)
        tabs.setupWithViewPager(containerFeedback)

    }
    private fun setupViewPager(viewPager : ViewPager){
        val adapter = FeedbackPageAdapter(supportFragmentManager)

        adapter.addFragment(BillingFragment(),"Bill")
        adapter.addFragment(FeedbackFragment(),"Feedback")
        viewPager.adapter = adapter
    }

}
