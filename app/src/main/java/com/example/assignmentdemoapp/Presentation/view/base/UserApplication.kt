package com.example.assignmentdemoapp.Presentation.view.base

import android.app.Application
import com.example.assignmentdemoapp.Presentation.di.PostModule
import com.example.assignmentdemoapp.Presentation.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class UserApplication : Application() {
    companion object {
        private lateinit var instance: UserApplication

        fun getInstance(): UserApplication = instance
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidLogger()
            androidContext(this@UserApplication)
            modules(
                listOf(
                    PostModule,
                    networkModule
                )
            )
        }
    }
}