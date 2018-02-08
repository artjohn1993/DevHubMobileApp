package co.devpartners.devhub.api.service

import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Dev_03 on 1/30/2018.
 */
interface DevHubBookingServices {
    @GET("users/{usersId}.json")
    fun getUsers(@Path("userId")userId:String)
    @GET("users/{firstname}.json")
    fun getFirstname(@Path("firstname")firstname:String)
}