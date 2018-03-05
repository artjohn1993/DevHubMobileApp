package co.devpartners.devhub.api.model

import java.util.*

/**
 * Created by Dev_03 on 1/30/2018.
 */
class User (val isAdmin: Boolean? = null
            , var firstName: String? = null
            , var lastName: String? = null
            , var middleName: String? = null
            , var userName: String? = null
            , var password: String? = null
            , var email:String? = null)