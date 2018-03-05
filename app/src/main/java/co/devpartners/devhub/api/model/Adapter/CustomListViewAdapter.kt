package co.devpartners.devhub.api.model.Adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import co.devpartners.devhub.R
import kotlinx.android.synthetic.main.reserved_listview_layout.view.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.textColor

/**
 * Created by DEVPARTNERS SOFTWARE on 2/28/2018.
 */
class CustomListAdapter(context : Context) : BaseAdapter(){
    val context : Context
    val status = listOf<String>("Reserved","Reserved","Cancel","Denied","Pending","Cancel","Reserved","Reserved","Reserved")
    val spaceType = listOf<String>("Conference Space","Open Space","Open Space","Private Space","Conference Space","Private Space","Conference Space","Conference Space","Conference Space")
    val period = listOf<String>("Monthly","Monthly","Weekly","Hourly","Hourly","Weekly","Weekly","Weekly","Weekly")


    init {
        this.context = context
    }


    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(context)
        val layout = layoutInflater.inflate(R.layout.reserved_listview_layout, p2,false)

        layout.statusText.text = status[p0]
        layout.statusText.textColor = Color.parseColor(checkColor(status[p0]))
        layout.reservedTitleText.text = spaceType[p0]
        layout.reservedLogoImage.setImageResource(checkStatusLogo(status[p0]))
        layout.periodText.text = period[p0]
        layout.reservedLogoImage.setColorFilter(Color.parseColor(checkColor(status[p0])))

        return layout
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return status.size
    }

    fun checkColor(status : String) : String {
        val result = when (status) {
            "Reserved" -> "#006600"
            "Cancel" -> "#7f0000"
            "Denied" -> "#7f0000"
            "Pending" ->"#ffab00"
            else -> "#000"
        }
        return result
    }
    fun checkStatusLogo(status : String) : Int {
        val result = when (status) {
            "Reserved" -> R.drawable.reserved
            "Cancel" -> R.drawable.cancel
            "Denied" -> R.drawable.denied
            "Pending" -> R.drawable.pending
            else -> R.drawable.add
        }
        return result
    }
    fun checkLogo(space : String) : Int{
        val result = when (space) {
            "Conference Space" -> R.drawable.conference
            "Open Space" -> R.drawable.openspace
            else -> R.drawable.privatespace
        }
        return result
    }

}
