package com.diargegaj.kaynewestoncesaid

import retrofit2.http.GET

/**
 * Created by Diar Gegaj on 21-05-01.
 */
interface KayneRestAPIService {

    @GET
    fun getKayneWestQuestion(): String

    companion object {
        const val KAYNE_REST_API_URL: String = "api.kanye.rest"
    }
}