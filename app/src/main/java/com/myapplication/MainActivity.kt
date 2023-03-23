package com.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.mvvmdaggercheezycode.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainVewModel: MainViewModel by viewModels()


    private val products: TextView
        get() = findViewById(R.id.products)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // mainVewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainVewModel.productsLiveData.observe(this) {
            products.text = it.joinToString { x -> x.title + "\n\n" }
        }
    }
}