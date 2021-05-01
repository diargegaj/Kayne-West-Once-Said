package com.diargegaj.kaynewestoncesaid.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.diargegaj.kaynewestoncesaid.R
import com.diargegaj.kaynewestoncesaid.ui.viewModels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var quoteViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        getQuoteFromApiAndUpdateView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.refreshIcon -> quoteViewModel.refreshQuote()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getQuoteFromApiAndUpdateView() {
        quoteViewModel.getQuote()?.observe(this, {
            quoteTextView.text = it.quote
        })
    }
}