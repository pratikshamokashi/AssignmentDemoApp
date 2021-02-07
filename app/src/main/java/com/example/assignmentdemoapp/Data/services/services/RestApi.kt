package com.example.assignmentdemoapp.Data.services.services

import com.example.assignmentdemoapp.Data.services.response.ResponseData
import io.reactivex.Observable
import retrofit2.Response

interface RestApi {
    fun getData(): Observable<Response<ResponseData>>
}