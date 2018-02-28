package co.devpartners.devhub.ui


import android.graphics.Color
import android.graphics.ColorFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.CalendarContract
import android.view.View
import android.view.WindowManager
import android.widget.*
import co.devpartners.devhub.R
import co.devpartners.devhub.api.events.CheckInTimeDialog
import co.devpartners.devhub.api.events.CustomDatePickerDialog
import co.devpartners.devhub.api.model.DatePickerType
import kotlinx.android.synthetic.main.activity_open_space.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.textColor


class OpenSpaceActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {

    val datepicker = CustomDatePickerDialog()
    var timepick = arrayOf("Length of Stay","Hourly", "Daily", "Weekly")
    var spinner: Spinner? = null
    val timepicker = CheckInTimeDialog()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_space)
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        this.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
        spinner = this.openSpinnerSchedule
        openSpinnerSchedule.onItemSelectedListener = this

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timepick)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        openSpinnerSchedule!!.adapter = adapter

        checkinTimeTextView.visibility = View.GONE
        checkoutTimeTextView.visibility = View.GONE

        openDatePickerButton.setOnClickListener{
            checkRoomType()
            showtext()

        }
        openNextButton.setOnClickListener {
            Handler().postDelayed({
                startActivity<BookingActivity>()
                finish()
            },400)
        }
    }
    override fun onNothingSelected(adapterView: AdapterView<*>?) {
    }
    override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, p3: Long) {

    }
    fun checkRoomType() {
        when (openSpinnerSchedule.selectedItem.toString()) {
            "Length of Stay" -> Toast.makeText(this, "Please identify your length of stay.",Toast.LENGTH_SHORT).show()
            "Hourly" -> timepicker.show(this)
            "Day" -> datepicker.show(this, DatePickerType.SINGLE)
            "Week" -> datepicker.show(this, DatePickerType.RANGE)
            else -> datepicker.show(this, DatePickerType.MULTIPLE)
        }
        when(openSpinnerSchedule.selectedItem.toString()){
            "Length of Stay" -> openDatePickerButton.textColor = Color.RED
            "Day" ->  openDatePickerButton.textColor = Color.BLACK
            "Week" -> openDatePickerButton.textColor = Color.BLACK
            "Hourly" -> openDatePickerButton.textColor = Color.BLACK
        }
    }
    fun showtext() {
        when (openSpinnerSchedule.selectedItem.toString()) {
            "Hourly" -> checkinTimeTextView.visibility = View.VISIBLE
        }
        when (openSpinnerSchedule.selectedItem.toString()) {
            "Hourly" -> checkoutTimeTextView.visibility = View.VISIBLE
        }
    }
}