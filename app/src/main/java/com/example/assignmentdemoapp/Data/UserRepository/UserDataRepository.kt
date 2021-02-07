package com.example.assignmentdemoapp.Data.UserRepository

import com.example.assignmentdemoapp.Data.DataMapper.UserDataMapper
import com.example.assignmentdemoapp.Data.services.services.RestApi
import com.example.assignmentdemoapp.Domain.domain.entity.ResponseDataEntiy
import com.example.assignmentdemoapp.Domain.repository.UserRepository
import io.reactivex.Observable

class UserDataRepository constructor(var mRestApi: RestApi, var mUserDataMapper: UserDataMapper) :
    UserRepository {
    override fun getData(): Observable<ResponseDataEntiy> {
        return mRestApi.getData()
            .map(mUserDataMapper::mapGetData)    }

}