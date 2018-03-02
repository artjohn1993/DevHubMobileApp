package co.devpartners.devhub.ui


import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
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
        spinner = this.fixedDeskDateSpinnerSchedule
        fixedDeskDateSpinnerSchedule.onItemSelectedListener = this

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timepick)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        fixedDeskDateSpinnerSchedule!!.adapter = adapter

        checkinTimeTextView.visibility = View.GONE
        checkoutTimeTextView.visibility = View.GONE

//        if(openMessageEditText.hasFocusable() == true){
//            openNextButton.visibility = GONE
//        }else{
//            openNextButton.visibility = VISIBLE
//        }

        fixedDeskDatePickerButton.setOnClickListener{
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
        when (fixedDeskDateSpinnerSchedule.selectedItem.toString()) {
            "Length of Stay" -> Toast.makeText(this, "Please identify your length of stay.",Toast.LENGTH_SHORT).show()
            "Hourly" -> timepicker.show(this)
            "Day" -> datepicker.show(this, DatePickerType.SINGLE)
            "Week" -> datepicker.show(this, DatePickerType.RANGE)
            else -> datepicker.show(this, DatePickerType.MULTIPLE)
        }
        when(fixedDeskDateSpinnerSchedule.selectedItem.toString()){
            "Length of Stay" -> fixedDeskDatePickerButton.textColor = Color.RED
            "Day" ->  fixedDeskDatePickerButton.textColor = Color.BLACK
            "Week" -> fixedDeskDatePickerButton.textColor = Color.BLACK
            "Hourly" -> fixedDeskDatePickerButton.textColor = Color.BLACK
        }
    }
    fun showtext() {
        when (fixedDeskDateSpinnerSchedule.selectedItem.toString()) {
            "Hourly" -> checkinTimeTextView.visibility = View.VISIBLE
        }
        when (fixedDeskDateSpinnerSchedule.selectedItem.toString()) {
            "Hourly" -> checkoutTimeTextView.visibility = View.VISIBLE
        }
    }
}