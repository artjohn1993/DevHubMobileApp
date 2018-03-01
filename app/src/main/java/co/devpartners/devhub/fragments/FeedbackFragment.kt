package co.devpartners.devhub.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import co.devpartners.devhub.R
import co.devpartners.devhub.api.model.CustomAdapter


/**
 * A simple [Fragment] subclass.
 */
class FeedbackFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_feedback, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.feedbackList)

        recycler.layoutManager = LinearLayoutManager(container?.context)
        recycler.adapter = CustomAdapter()

        return view
    }

}
