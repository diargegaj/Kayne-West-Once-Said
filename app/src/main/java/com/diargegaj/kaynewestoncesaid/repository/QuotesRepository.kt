package com.diargegaj.kaynewestoncesaid.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.diargegaj.kaynewestoncesaid.models.QuoteModel
import com.diargegaj.kaynewestoncesaid.instances.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Diar Gegaj on 21-05-01.
 */
class QuotesRepository {
    private var quoteModel: MutableLiveData<QuoteModel>? = null
    private val TAG = "QuotesRepository"

    fun getQuote(): MutableLiveData<QuoteModel>? {
        if (quoteModel == null) {
            quoteModel = MutableLiveData()
            loadQuoteFromAPI()
        }

        return quoteModel
    }

    private fun loadQuoteFromAPI() {
        RetrofitInstance.service.getKayneWestQuestion().enqueue(object : Callback<QuoteModel> {
            override fun onResponse(call: Call<QuoteModel>, response: Response<QuoteModel>) {
                quoteModel?.value = response.body()
                Log.d(TAG, "response: ${response.body()?.quote}")
            }

            override fun onFailure(call: Call<QuoteModel>, t: Throwable) {
                Log.d(TAG, "failed to get data from API = ${t.message}", t)
            }
        })
    }

    fun refreshQuote() {
        loadQuoteFromAPI()
    }
}