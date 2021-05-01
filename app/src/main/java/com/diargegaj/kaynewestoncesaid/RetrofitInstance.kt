package com.diargegaj.kaynewestoncesaid

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Diar Gegaj on 21-05-01.
 */
object RetrofitInstance {
    val retrofit = Retrofit.Builder()
        .baseUrl(KayneRestAPIService.KAYNE_REST_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: KayneRestAPIService = retrofit.create(KayneRestAPIService::class.java)
}