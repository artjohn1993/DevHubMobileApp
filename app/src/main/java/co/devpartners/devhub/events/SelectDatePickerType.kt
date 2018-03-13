package co.devpartners.devhub.events

import co.devpartners.devhub.model.DatePickerType
import com.applikeysolutions.cosmocalendar.utils.SelectionType

/**
 * Created by DEVPARTNERS SOFTWARE on 2/8/2018.
 */
open class SelectDatePickerType {

    fun select(datePickerType : DatePickerType): Int{

        when(datePickerType){
            DatePickerType.SINGLE ->{ return SelectionType.SINGLE }
            DatePickerType.MULTIPLE ->{ return SelectionType.MULTIPLE }
            DatePickerType.RANGE ->{ return SelectionType.RANGE }
            else ->{ return SelectionType.NONE }
        }

    }
}