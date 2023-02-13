package com.example.getusers.data.remote.firebase.realtime

import com.example.getusers.data.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface FirebaseService {

    @PUT("Users/{id}.json")
    fun addUser(@Path("id") id: String, @Body user: User): Call<Void>

    @PUT("Users/{id}.json")
    fun updateUser(@Path("id") id:String, @Body user: User) : Call<Void>

    @DELETE("Users/{id}.json")
    fun deleteUser(@Path("id") id:String) :Call<Void>

    @GET("Users/{id}.json")
    fun getUser(@Path("id") id: String): Call<User>

    @GET("Users.json")
    fun getAllUsers(): Call<Map<String, User>>

}
