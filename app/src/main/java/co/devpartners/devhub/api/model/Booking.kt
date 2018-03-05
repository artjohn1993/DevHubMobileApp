package co.devpartners.devhub.api.model

import java.util.*

/**
 * Created by Dev_03 on 1/30/2018.
 */
class Booking (var email:String?=null
               , val firstName: String? = null
               , val lastName: String? = null
               , val middleName: String? = null
               , var dateOfArrival: Date? = null
               , var dateOfDeparture: Date? = null
               , val spaceType: Int? = null
               , val frequencyType: Int? = null
               , var timeIn: String? = null
               , var timeOut: String? = null
               , val contactNumber: Array<ContactNumber>? = null
               , val remarks: String? = null
               , val roomType: String? = null
               , val duration: String? = null
               , val bill: String? = null
               , val period: String? = null
               , val rate: String? = null
               , val timeInFormat: String? = null
               , val personCount: Int? = null
               , val haveBookedBefore: Boolean? = null
               , val bookStatus: Int? = null
               , val bookType: Int? = null
               , val refCode: String? = null
               , val profession: String? = null)