package co.devpartners.devhub.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import co.devpartners.devhub.R


/**
 * A simple [Fragment] subclass.
 */
class ConferenceFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conference, container, false)
    }

}// Required empty public constructor
