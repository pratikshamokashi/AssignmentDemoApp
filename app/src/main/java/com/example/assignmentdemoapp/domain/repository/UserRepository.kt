package com.example.assignmentdemoapp.domain.repository

import com.example.assignmentdemoapp.Data.services.services.NetworkServices
import com.example.assignmentdemoapp.domain.domain.entity.ResponseDataEntiy
import io.reactivex.Observable

interface UserRepository {
    fun getData():Observable<ResponseDataEntiy>
}