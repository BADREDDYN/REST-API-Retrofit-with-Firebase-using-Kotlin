package com.example.getusers.repos.remote.firebase.realtime

import com.example.getusers.data.User
import retrofit2.Call

interface RealtimeRepository {
    fun addUser(user: User): Call<Void>
    fun updateUser(user: User) : Call<Void>
    fun deleteUser(user: User) : Call<Void>
    fun getAllUsers() : Call<Map<String, User>>
}