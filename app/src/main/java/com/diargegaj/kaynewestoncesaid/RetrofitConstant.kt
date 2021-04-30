package com.diargegaj.kaynewestoncesaid

import retrofit2.Retrofit
/**
 * Created by Diar Gegaj on 21-05-01.
 */
object RetrofitConstant {
    val retrofit = Retrofit.Builder()
        .baseUrl(KayneRestAPIService.KAYNE_REST_API_URL)
        .build()

    val service: KayneRestAPIService = retrofit.create(KayneRestAPIService::class.java)
}