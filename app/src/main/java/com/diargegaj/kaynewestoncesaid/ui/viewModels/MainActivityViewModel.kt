package com.diargegaj.kaynewestoncesaid.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diargegaj.kaynewestoncesaid.models.QuoteModel
import com.diargegaj.kaynewestoncesaid.repository.QuotesRepository

/**
 * Created by Diar Gegaj on 21-05-01.
 */
class MainActivityViewModel: ViewModel() {
    private val repository = QuotesRepository()

    fun getQuote(): MutableLiveData<QuoteModel>? {
        return repository.getQuote()
    }

    fun refreshQuote() {
        repository.refreshQuote()
    }

}