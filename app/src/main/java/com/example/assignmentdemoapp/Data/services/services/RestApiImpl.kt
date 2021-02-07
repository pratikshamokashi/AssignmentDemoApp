package com.example.assignmentdemoapp.Data.services.services

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.example.assignmentdemoapp.Data.services.response.ResponseData
import com.example.assignmentdemoapp.Data.services.services.NetworkServices
import com.example.assignmentdemoapp.Data.services.services.RestApi
import io.reactivex.Observable
import retrofit2.Response

class RestApiImp constructor(
    var mNetworkService: NetworkServices,
    var mContext: Context
) : RestApi {
    override fun getData(): Observable<Response<ResponseData>> {
        return Observable.create<Response<ResponseData>> { emitter ->

            if (!isThereInternetConnection()) {
//                emitter.onError("")
                return@create
            }
            val sessionEntity: Response<ResponseData> =
                mNetworkService.getData().execute()

            Log.e("Session",sessionEntity.toString())
            if (sessionEntity.isSuccessful) {
                if (sessionEntity.body() != null) {
                    emitter.onNext(sessionEntity)

                    emitter.onComplete()
                } else {
                    emitter.onError(UnknownError())
                }
            } else {
                val error = sessionEntity.errorBody()
                Log.e("Error", "" + error)
//                val errorResponse: ErrorResponse? =
//                    gson.fromJson(sessionEntity.errorBody()!!.charStream(), type)
//                emitter.onError()
            }
        }

    }
    @SuppressLint("MissingPermission")
    fun isThereInternetConnection(): Boolean {
        val cm =
            this.mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return cm!!.activeNetworkInfo != null
    }
}