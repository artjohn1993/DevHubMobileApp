package co.devpartners.devhub.api.model.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by DEVPARTNERS SOFTWARE on 3/1/2018.
 */
class FeedbackPageAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    private val fragmentlist  = ArrayList<Fragment>()
    private val titlelist  = ArrayList<String>()

    fun addFragment(fragment : Fragment, title : String){
        fragmentlist.add(fragment)
        titlelist.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {


        return titlelist[position]
    }
    override fun getItem(position: Int): Fragment {
        return fragmentlist[position]
    }

    override fun getCount(): Int {
        return fragmentlist.size
    }
}


