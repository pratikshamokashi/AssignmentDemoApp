package com.example.assignmentdemoapp.Presentation.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.assignmentdemoapp.Presentation.view.base.Status
import com.example.assignmentdemoapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel : DataViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.getDataRequest()
        setupObserver()
    }
    private fun setupObserver() {
        mainViewModel.dataResponse().observe(this, Observer {

            when(it.status){
                Status.SUCCESS->{Log.e("TAG SUCCESS", it.data.toString())}
                Status.LOADING->{Log.e("TAG Loading", "Loading")}
                Status.ERROR->{Log.e("TAG Error", "Error")}
            }

        })
    }

}