package com.example.getusers.model.remote

import com.example.getusers.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("users/id1/.json")
    fun getUser() : Call<User>

}