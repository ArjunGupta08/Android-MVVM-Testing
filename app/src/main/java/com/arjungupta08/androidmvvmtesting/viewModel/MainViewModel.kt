package com.arjungupta08.androidmvvmtesting.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arjungupta08.androidmvvmtesting.model.ProductListItem
import com.arjungupta08.androidmvvmtesting.repository.ProductRepository
import com.arjungupta08.androidmvvmtesting.utils.NetworkResult
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository) : ViewModel() {

    private val mutableLiveData = MutableLiveData<NetworkResult<List<ProductListItem>>>()
    val liveData: LiveData<NetworkResult<List<ProductListItem>>>
        get() = mutableLiveData

    fun getProducts() {
        viewModelScope.launch {
            mutableLiveData.postValue(NetworkResult.Loading())
            val getProducts = repository.getProducts()
            mutableLiveData.postValue(getProducts)
        }
    }

}