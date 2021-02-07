package com.example.assignmentdemoapp.Domain.repository

import com.example.assignmentdemoapp.Domain.domain.entity.ResponseDataEntiy
import io.reactivex.Observable

interface UserRepository {
    fun getData():Observable<ResponseDataEntiy>
}