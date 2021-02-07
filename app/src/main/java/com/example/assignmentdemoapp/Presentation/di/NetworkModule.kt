package com.example.assignmentdemoapp.Presentation.di

import android.content.Context
import com.example.assignmentdemoapp.Data.DataMapper.UserDataMapper
import com.example.assignmentdemoapp.Data.UserRepository.UserDataRepository
import com.example.assignmentdemoapp.Data.services.services.NetworkServices
import com.example.assignmentdemoapp.Data.services.services.RestApi
import com.example.assignmentdemoapp.Data.services.services.RestApiImp
import com.example.assignmentdemoapp.Domain.interactor.DataUC
import com.example.assignmentdemoapp.Domain.repository.UserRepository
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        createRetrofit(
            createOkHttpClient()
        )
    }
    single { createNetworkApi(get()) }
    single {
        createRestAPI(
            get(),
            get()
        )
    }
    single {
        createUserRepository(
            get(),
            get()
        )
    }

    single { createDataUC(get()) }

}


fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .baseUrl("http://demo1929804.mockable.io/")
        .client(okHttpClient)
        .build()
}

fun createOkHttpClient(): OkHttpClient {

    val httpClient = OkHttpClient.Builder()

    httpClient.addInterceptor { chain ->
        val original = chain.request()
        val request = original.newBuilder()
            .header("Api-Version", "v1")
            .header("Accept", "application/json")
            .build()

        chain.proceed(request)
    }
        .retryOnConnectionFailure(true)
        .callTimeout(
            2, TimeUnit.MINUTES
        )
        .connectTimeout(3000, TimeUnit.SECONDS)
        .writeTimeout(4000, TimeUnit.SECONDS)
        .readTimeout(3000, TimeUnit.SECONDS)

    return httpClient.build()
}

fun createNetworkApi(retrofit: Retrofit): NetworkServices {
    return retrofit.create(NetworkServices::class.java)
}

fun createRestAPI(mNetworkService: NetworkServices, mContext: Context): RestApi {
    return RestApiImp(
        mNetworkService,
        mContext
    )
}

fun createUserRepository(mRestApi: RestApi, mapper: UserDataMapper): UserRepository {
    return UserDataRepository(mRestApi, mapper)
}
fun createDataUC(
    mUserRepository: UserRepository
): DataUC {
    return DataUC(mUserRepository)

}
