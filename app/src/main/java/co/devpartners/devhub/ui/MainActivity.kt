package co.devpartners.devhub.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import co.devpartners.devhub.R
import co.devpartners.devhub.fragments.*
import com.github.fabtransitionactivity.SheetLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_space_type.*
import android.content.Intent
import android.graphics.Color


class MainActivity : AppCompatActivity(),SheetLayout.OnFabAnimationEndListener {
    private val REQUEST_CODE = 1

    private val selectedItem = object : BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.getItemId()) {
                R.id.navigationReserved -> {

                    val fragment1 = ReservedFragment()
                    val fragmentTransaction1 = supportFragmentManager.beginTransaction()
                    fragmentTransaction1.replace(R.id.mainFrame, fragment1, "FragmentName")
                    fragmentTransaction1.commit()
                    return true
                }
                R.id.navigationPending -> {

                    val fragment2 = PendingFragment()
                    val fragmentTransaction2 = supportFragmentManager.beginTransaction()
                    fragmentTransaction2.replace(R.id.mainFrame, fragment2, "FragmentName")
                    fragmentTransaction2.commit()
                    return true
                }

            }
            return false
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainMenu.setOnNavigationItemSelectedListener(selectedItem)
        title = "Home"
        val fragment1 = ReservedFragment()
        val fragmentTransaction1 = supportFragmentManager.beginTransaction()
        fragmentTransaction1.replace(R.id.mainFrame, fragment1, "FragmentName")
        fragmentTransaction1.commit()

        bottom_sheet.setFab(fab)
        bottom_sheet.setFabAnimationEndListener(this)
        fab.setBackgroundColor(Color.parseColor("#c67c00"))

        fab.setOnClickListener {
            bottom_sheet.expandFab()
        }
    }


    override fun onFabAnimationEnd() {
        val intent = Intent(this, SpaceTypeActivity::class.java)
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE){
            bottom_sheet.contractFab()
        }
    }

}
