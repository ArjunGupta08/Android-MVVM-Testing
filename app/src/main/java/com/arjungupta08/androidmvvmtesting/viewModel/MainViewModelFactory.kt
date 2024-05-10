package com.arjungupta08.androidmvvmtesting.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arjungupta08.androidmvvmtesting.repository.ProductRepository

class MainViewModelFactory(private val productRepository: ProductRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(productRepository) as T
    }

}