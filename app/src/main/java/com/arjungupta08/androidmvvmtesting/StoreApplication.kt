package com.arjungupta08.androidmvvmtesting

import android.app.Application
import com.arjungupta08.androidmvvmtesting.api.ProductsAPI
import com.arjungupta08.androidmvvmtesting.repository.ProductRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StoreApplication : Application() {

    private lateinit var productsAPI: ProductsAPI
    lateinit var productRepository: ProductRepository

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://fakestoreapi.com/")
            .build()

        productsAPI = retrofit.create(ProductsAPI::class.java)
        productRepository = ProductRepository(productsAPI)
    }
}