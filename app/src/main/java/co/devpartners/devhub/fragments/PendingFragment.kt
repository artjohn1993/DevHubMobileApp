package co.devpartners.devhub.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView

import co.devpartners.devhub.R
import co.devpartners.devhub.ui.InformationActivity
import org.jetbrains.anko.support.v4.startActivity


/**
 * A simple [Fragment] subclass.
 */
class PendingFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_pending, container, false)
        val listview = view.findViewById<ListView>(R.id.pendingListView)
        listview.adapter = PendingFragment.ReservedCustomAdapter(this.activity!!)
        listview.setOnItemClickListener { adapterView, view, i, l ->

            startActivity<InformationActivity>()
        }

        return view
    }

    private class ReservedCustomAdapter(context : Context) : BaseAdapter(){
        val context : Context

        init {
            this.context = context
        }


        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(R.layout.pending_listview_layout, p2,false)

            return layout
        }

        override fun getItem(p0: Int): Any {
            return p0
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return 2
        }

    }

}// Required empty public constructor
