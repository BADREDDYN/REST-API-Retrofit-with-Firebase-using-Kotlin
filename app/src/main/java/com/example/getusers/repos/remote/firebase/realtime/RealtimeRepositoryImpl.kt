package com.example.getusers.repos.remote.firebase.realtime

import com.example.getusers.data.User
import com.example.getusers.data.remote.firebase.realtime.RetrofitClient.firebaseService
import retrofit2.Call

class RealtimeRepositoryImpl: RealtimeRepository {

    //User
    override fun addUser(user: User): Call<Void> =
        firebaseService.addUser(user.id, user)

    override fun updateUser(user: User): Call<Void> =
        firebaseService.updateUser(user.id, user)

    override fun deleteUser(user: User): Call<Void> =
        firebaseService.deleteUser(user.id)

    override fun getAllUsers(): Call<Map<String, User>> =
        firebaseService.getAllUsers()

}