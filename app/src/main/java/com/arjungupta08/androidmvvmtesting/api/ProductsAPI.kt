package com.arjungupta08.androidmvvmtesting.api

import com.arjungupta08.androidmvvmtesting.model.ProductListItem
import retrofit2.Response
import retrofit2.http.GET

interface ProductsAPI {

    @GET("/products")
    suspend fun getProducts() : Response<List<ProductListItem>>

}