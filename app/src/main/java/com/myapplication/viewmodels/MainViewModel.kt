package com.mvvmdaggercheezycode.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvvmdaggercheezycode.models.Product
import com.mvvmdaggercheezycode.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel() {
    val productsLiveData : LiveData<List<Product>>
    get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}
