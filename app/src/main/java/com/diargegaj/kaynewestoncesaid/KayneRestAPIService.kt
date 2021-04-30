package com.diargegaj.kaynewestoncesaid

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Diar Gegaj on 21-05-01.
 */
interface KayneRestAPIService {

    @GET("a")
    fun getKayneWestQuestion(): Call<QuoteModel>

    companion object {
        const val KAYNE_REST_API_URL: String = "http://api.kanye.rest/"
    }
}