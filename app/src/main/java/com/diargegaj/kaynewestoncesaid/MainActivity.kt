package com.diargegaj.kaynewestoncesaid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitConstant.service.getKayneWestQuestion().enqueue(object : Callback<QuoteModel> {
            override fun onResponse(call: Call<QuoteModel>, response: Response<QuoteModel>) {
                quoteTextView.text = response.body()?.quote
                Log.d("diari1", "response: ${response.body()?.quote}")
            }

            override fun onFailure(call: Call<QuoteModel>, t: Throwable) {
                Log.d("diari1", "failed = ${t.message}", t)
            }

        })
    }
}