package co.devpartners.devhub.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.devpartners.devhub.R
import com.github.fabtransitionactivity.SheetLayout
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.graphics.Color
import co.devpartners.devhub.api.model.CustomListAdapter
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity(),SheetLayout.OnFabAnimationEndListener {
    private val REQUEST_CODE = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mainRecycleView.layoutManager = LinearLayoutManager(this)
//        mainRecycleView.adapter = CustomAdapter()

        mainListView.adapter = CustomListAdapter(this)
        mainListView.setOnItemClickListener { adapterView, view, i, l ->

            startActivity<InformationActivity>()
        }


        bottom_sheet.setFab(fab)
        bottom_sheet.setFabAnimationEndListener(this)
        fab.setBackgroundColor(Color.parseColor("#c67c00"))

        fab.setOnClickListener {
            bottom_sheet.expandFab()
        }
    }


    override fun onFabAnimationEnd() {
        val intent = Intent(this, SpaceServices::class.java)
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE){
            bottom_sheet.contractFab()
        }
    }

}
