package com.example.assignmentdemoapp.domain.interactor

import com.example.assignmentdemoapp.domain.domain.entity.ResponseDataEntiy
import com.example.assignmentdemoapp.domain.repository.UserRepository
import io.reactivex.Observable


class DataUC constructor(val userRepository: UserRepository) :
    UseCase<ResponseDataEntiy, Unit>() {

    //unit add kela tar zala he ahe ka right?

    override fun build(param: Unit): Observable<ResponseDataEntiy> {
        return  userRepository.getData()

    }
}