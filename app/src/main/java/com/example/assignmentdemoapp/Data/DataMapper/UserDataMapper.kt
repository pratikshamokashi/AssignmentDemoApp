package com.example.assignmentdemoapp.Data.DataMapper

import com.example.assignmentdemoapp.Data.services.response.ResponseData
import com.example.assignmentdemoapp.domain.domain.entity.ResponseDataE
import com.example.assignmentdemoapp.domain.domain.entity.ResponseDataEntiy
import retrofit2.Response

class UserDataMapper {
    fun mapGetData(responseData: Response<ResponseData>):ResponseDataEntiy{
        val dataResponse: ResponseData? = responseData.body()

        val responseDataEntity = ResponseDataEntiy()
        responseDataEntity.success = dataResponse?.success

        return responseDataEntity
    }
}
//rest api madhe samjel jar error ala tre debug kartana