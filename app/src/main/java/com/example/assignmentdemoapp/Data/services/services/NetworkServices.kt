package com.example.assignmentdemoapp.Data.services.services

import com.example.assignmentdemoapp.Data.services.response.ResponseData
import retrofit2.Call
import retrofit2.http.GET

interface NetworkServices {
    @GET("assignment")
    fun getData() : Call<ResponseData>
}