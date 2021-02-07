package com.example.assignmentdemoapp.Presentation.view

import com.example.assignmentdemoapp.Presentation.view.base.Status
import com.example.assignmentdemoapp.domain.domain.entity.ResponseDataEntiy
import com.google.gson.annotations.SerializedName

class DataModel(
    status: Status,
    var mResponseDataEntiy: ResponseDataEntiy?,
    var error: Throwable?
) {


    @SerializedName("Success")
    var success: Boolean? = null
    @SerializedName("Message")
    var message: String? = null
    @SerializedName("Data")
    var data: List<ResponseDataEntiy>? = null

    var status: Status? = status

    companion object {

        fun success(response: ResponseDataEntiy): DataModel {
            return DataModel(Status.SUCCESS, response, null)
        }

        fun error(error: Throwable): DataModel {
            return DataModel(Status.ERROR, null, error)
        }
    }
}
