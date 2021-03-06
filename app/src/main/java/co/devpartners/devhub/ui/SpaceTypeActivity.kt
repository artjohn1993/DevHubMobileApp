package co.devpartners.devhub.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import android.view.WindowManager
import co.devpartners.devhub.R
import co.devpartners.devhub.events.CustomDatePickerDialog
import co.devpartners.devhub.fragments.ConferenceFragment
import co.devpartners.devhub.fragments.OpenFragment
import co.devpartners.devhub.fragments.PrivateFragment
import kotlinx.android.synthetic.main.activity_space_type.*


class SpaceTypeActivity : AppCompatActivity() {
    val datepicker = CustomDatePickerDialog()
    private val selectedItem = object : BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.getItemId()) {
                R.id.navigationOpen -> {
                    val fragment1 = OpenFragment()
                    val fragmentTransaction1 = supportFragmentManager.beginTransaction()
                    fragmentTransaction1.replace(R.id.frame, fragment1, "FragmentName")
                    fragmentTransaction1.commit()
                    return true
                }
                R.id.navigationPrivate -> {
                    val fragment2 = PrivateFragment()
                    val fragmentTransaction2 = supportFragmentManager.beginTransaction()
                    fragmentTransaction2.replace(R.id.frame, fragment2, "FragmentName")
                    fragmentTransaction2.commit()
                    return true
                }
                R.id.navigationConference -> {
                    val fragment3 = ConferenceFragment()
                    val fragmentTransaction3 = supportFragmentManager.beginTransaction()
                    fragmentTransaction3.replace(R.id.frame, fragment3, "FragmentName")
                    fragmentTransaction3.commit()
                    return true
                }
            }
            return false
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_space_type)
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        navigationBottom.setOnNavigationItemSelectedListener(selectedItem)
        val fragment1 = OpenFragment()
        val fragmentTransaction1 = supportFragmentManager.beginTransaction()
        fragmentTransaction1.replace(R.id.frame, fragment1, "FragmentName")
        fragmentTransaction1.commit()

    }

}
