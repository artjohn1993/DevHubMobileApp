package co.devpartners.devhub.api.service

import co.devpartners.devhub.api.model.DevHubResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Dev_03 on 1/30/2018.
 */
interface DevHubBookingServices {
    @GET("users/{usersId}.json")
    fun getUsers(@Path("userId")userId:String): Call<DevHubResponse>
    @GET("users/{firstName}.json")
    fun getFirstname(@Path("firstName")firstname:String) : Call<DevHubResponse>
}