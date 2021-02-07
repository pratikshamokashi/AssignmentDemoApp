package com.example.assignmentdemoapp.Presentation.di

import com.example.assignmentdemoapp.Data.DataMapper.UserDataMapper
import com.example.assignmentdemoapp.Presentation.view.DataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val PostModule = module {
    viewModel { DataViewModel(get()) }

    factory { UserDataMapper() }

//    single { Navigator }
}