package com.example.getusers.ui

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.getusers.R
import com.example.getusers.data.User
import com.example.getusers.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Write User
        binding.btnAddUser.setOnClickListener {
            val user = randomUser()
            vm.addUser(user)

            delay(5000) {
                vm.deleteUser(user)
            }

            vm.getAllUsers()
        }

        //Get Users
        vm.getAllUsers()
        var usersList: ArrayList<User>
        vm.getAllUsersMutableLiveData.observe(this) { users ->
            usersList = users

            Log.d("dev21", usersList.toString())
        }


    }

    private fun randomUser(): User {
        val id = UUID.randomUUID().toString()
        val name = "User_$id"
        val age = (16..70).random()
        return User(id, name, age)
    }

    private fun delay(time: Long, action: () -> Unit) {
        Handler().postDelayed({
            action()
        }, time)
    }
}