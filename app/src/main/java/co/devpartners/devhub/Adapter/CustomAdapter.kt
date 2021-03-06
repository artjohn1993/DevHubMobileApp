package co.devpartners.devhub.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import co.devpartners.devhub.R

/**
 * Created by DEVPARTNERS SOFTWARE on 2/28/2018.
// */
class CustomAdapter :RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {
        return 10
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val layout = layoutInflater.inflate(R.layout.layout_feedback,parent,false)

        return CustomViewHolder(layout)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {

    }
}

class CustomViewHolder(val view : View) : RecyclerView.ViewHolder(view){
    val name = view.findViewById<TextView>(R.id.feedbackName)
}