package com.diargegaj.kaynewestoncesaid.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.diargegaj.kaynewestoncesaid.QuoteModel
import com.diargegaj.kaynewestoncesaid.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Diar Gegaj on 21-05-01.
 */
class QuotesRepository {
    private var quoteModel: MutableLiveData<QuoteModel>? = null

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
                Log.d("diari1", "response: ${response.body()?.quote}")
            }

            override fun onFailure(call: Call<QuoteModel>, t: Throwable) {
                Log.d("diari1", "failed = ${t.message}", t)
            }
        })
    }

    fun refreshQuote() {
        loadQuoteFromAPI()
    }
}