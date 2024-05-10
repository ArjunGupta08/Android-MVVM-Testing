package com.arjungupta08.androidmvvmtesting.repository

import com.arjungupta08.androidmvvmtesting.api.ProductsAPI
import com.arjungupta08.androidmvvmtesting.model.ProductListItem
import com.arjungupta08.androidmvvmtesting.utils.NetworkResult

class ProductRepository(private val productsAPI: ProductsAPI) {

    suspend fun getProducts(): NetworkResult<List<ProductListItem>> {
        val response = productsAPI.getProducts()
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkResult.Success(responseBody)
            } else {
                NetworkResult.Error("Something went wrong")
            }
        } else {
            NetworkResult.Error("Something went wrong")
        }
    }

}