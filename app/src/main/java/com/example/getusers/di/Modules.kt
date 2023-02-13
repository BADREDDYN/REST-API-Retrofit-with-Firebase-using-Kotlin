package com.example.getusers.di

import com.example.getusers.repos.remote.firebase.realtime.RealtimeRepositoryImpl
import com.example.getusers.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { RealtimeRepositoryImpl() }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}