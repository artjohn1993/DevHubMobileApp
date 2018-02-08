package co.devpartners.devhub.api.model

import java.util.*

/**
 * Created by Dev_03 on 1/30/2018.
 */
class User (val id: String? = null
            , val firstname: String? = null
            , val lastname: String? = null
            , val address: String? = null
            , var checkin: Date? = null
            , var checkout: Date? = null
            , val contact: String? = null
            , val email:String? = null)