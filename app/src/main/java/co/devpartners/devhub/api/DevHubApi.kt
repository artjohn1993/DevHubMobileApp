package co.devpartners.devhub.api

import co.devpartners.devhub.service.DevHubBookingServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Dev_03 on 1/30/2018.
 */
class DevHubApi {

    private val devhubService: DevHubBookingServices

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        devhubService = retrofit.create(DevHubBookingServices::class.java)
    }
}