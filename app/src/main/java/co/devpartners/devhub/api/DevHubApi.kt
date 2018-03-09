package co.devpartners.devhub.api

import co.devpartners.devhub.api.model.DevHubResponse
import co.devpartners.devhub.api.service.DevHubBookingServices
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path

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