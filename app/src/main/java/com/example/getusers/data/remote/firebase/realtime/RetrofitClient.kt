package com.example.getusers.data.remote.firebase.realtime

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private const val BASE_URL = "https://retrofit-23ea9-default-rtdb.firebaseio.com/"
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val firebaseService: FirebaseService by lazy {
        retrofit.create(FirebaseService::class.java)
    }
}