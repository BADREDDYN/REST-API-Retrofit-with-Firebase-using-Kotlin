package com.example.getusers.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.getusers.R
import com.example.getusers.databinding.ActivityMainBinding
import com.example.getusers.model.User
import com.example.getusers.model.remote.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://rest-api-retrofit-default-rtdb.firebaseio.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val apiInterface = retrofit.create(ApiInterface::class.java)
        val call: Call<User> = apiInterface.getUser()

        call.enqueue(object : Callback<User> {

            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                binding.tvUser.text = "${response?.body()?.name} - ${response?.body()?.age}"
            }

            override fun onFailure(call: Call<User>?, t: Throwable?) {
                binding.tvUser.text = "${t?.message}"
            }

        })

    }
}