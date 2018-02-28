package co.devpartners.devhub.api.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import co.devpartners.devhub.R

/**
 * Created by DEVPARTNERS SOFTWARE on 2/28/2018.
 */
class CustomListAdapter(context : Context) : BaseAdapter(){
    val context : Context

    init {
        this.context = context
    }


    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(context)
        val layout = layoutInflater.inflate(R.layout.reserved_listview_layout, p2,false)

        return layout
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return 20
    }


}
