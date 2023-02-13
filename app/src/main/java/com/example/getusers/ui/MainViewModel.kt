package com.example.getusers.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.getusers.data.User
import com.example.getusers.repos.remote.firebase.realtime.RealtimeRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(
    private val realtimeRepo: RealtimeRepositoryImpl
) : ViewModel() {


    // User
    fun addUser(user: User): Call<Void> =
        realtimeRepo.addUser(user).also {
            it.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Log.d("tag16", response.message())
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.d("tag16", t.message.toString())
                }
            })
        }


    fun updateUser(user: User): Call<Void> =
        realtimeRepo.updateUser(user).also {
            it.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Log.d("tag16", response.message())
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.d("tag16", t.message.toString())
                }
            })
        }


    fun deleteUser(user: User): Call<Void> =
        realtimeRepo.deleteUser(user).also {
            it.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Log.d("tag16", response.message())
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.d("tag16", t.message.toString())
                }
            })
        }


    private val _getAllUsersMutableLiveData = MutableLiveData<ArrayList<User>>()
    val getAllUsersMutableLiveData:LiveData<ArrayList<User>> get() = _getAllUsersMutableLiveData

    fun getAllUsers(): Call<Map<String, User>> =
        realtimeRepo.getAllUsers()
            .also {
                it.enqueue(object : Callback<Map<String, User>> {
                    override fun onResponse(
                        call: Call<Map<String, User>>,
                        response: Response<Map<String, User>>
                    ) {
                        if (response.isSuccessful) {
                            response.body()?.let { users ->
                                val usersList = ArrayList<User>().apply { addAll(users.values) }
                                _getAllUsersMutableLiveData.value = usersList
                            }
                        }
                    }

                    override fun onFailure(call: Call<Map<String, User>>, t: Throwable) {
                        Log.d("tag16", t.message.toString())
                    }
                })
            }


}