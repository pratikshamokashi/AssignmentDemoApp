package com.example.assignmentdemoapp.Domain.interactor

import com.example.assignmentdemoapp.Domain.domain.entity.ResponseDataEntiy
import com.example.assignmentdemoapp.Domain.repository.UserRepository
import io.reactivex.Observable


class DataUC constructor(val userRepository: UserRepository) :
    UseCase<ResponseDataEntiy, Unit>() {

    override fun build(param: Unit): Observable<ResponseDataEntiy> {
        return  userRepository.getData()

    }
}