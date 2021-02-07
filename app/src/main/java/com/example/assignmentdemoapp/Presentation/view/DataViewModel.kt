package com.example.assignmentdemoapp.Presentation.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignmentdemoapp.domain.domain.entity.ResponseDataEntiy
import com.example.assignmentdemoapp.domain.interactor.DataUC
import io.reactivex.observers.DisposableObserver

class DataViewModel(var mDataUc :DataUC) :ViewModel() {

        var mMutableLiveDataModel = MutableLiveData<DataModel>()
        
        fun dataResponse(): LiveData<DataModel> {
            return mMutableLiveDataModel
        }
    

        fun getDataRequest() {
            mDataUc.execute(object : DisposableObserver<ResponseDataEntiy>() {
                override fun onComplete() {
                    Log.d("TAG--> ", "onComplete")

                }

                override fun onNext(response: ResponseDataEntiy) {
                    mMutableLiveDataModel.value = DataModel.success(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("TAG--> ", "onError" + e.message)
                    mMutableLiveDataModel.value = DataModel.error(e)
                }


            }, Unit)
        }

    }
