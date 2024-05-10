package com.arjungupta08.androidmvvmtesting

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.arjungupta08.androidmvvmtesting.viewModel.MainViewModel
import com.arjungupta08.androidmvvmtesting.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val repository = (application as StoreApplication).productRepository
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository))[MainViewModel::class.java]
        mainViewModel.getProducts()

        mainViewModel.liveData.observe(this) {
            Log.d("API DATA", it.data.toString())
        }
    }
}