package com.swapon.simplenetworkoperationusingmvvm.view

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.os.Bundle
import android.util.Log

import com.swapon.simplenetworkoperationusingmvvm.R
import com.swapon.simplenetworkoperationusingmvvm.model.pojo.User
import com.swapon.simplenetworkoperationusingmvvm.viewmodel.UserActivityViewModel

class UserActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val userActivityViewModel = ViewModelProvider(this).get(UserActivityViewModel::class.java)
        userActivityViewModel.allUsers.observe(this, Observer { user ->
            Log.d(TAG, "user.size: " + user.data!!.size)

            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(this@UserActivity)

            val userAdapter = UserAdapter(applicationContext, user.data!!)
            recyclerView.adapter = userAdapter
        })

    }

    companion object {
        private val TAG = "UserActivity"
    }
}
