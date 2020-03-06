package com.swapon.simplenetworkoperationusingmvvm.model.repository

import android.app.Application

import androidx.lifecycle.MutableLiveData

import com.google.gson.Gson
import com.swapon.simplenetworkoperationusingmvvm.model.repository.remote.ApiClient
import com.swapon.simplenetworkoperationusingmvvm.model.repository.remote.ApiInterface
import com.swapon.simplenetworkoperationusingmvvm.model.pojo.User


import java.io.IOException

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(private val application: Application) {
    private var mutableLiveData: MutableLiveData<User>? = null
    private var apiInterface: ApiInterface? = null

    val userData: MutableLiveData<User>
        get() {

            if (mutableLiveData == null) {
                mutableLiveData = MutableLiveData()
            }

            apiInterface = ApiClient.apiClient?.create(ApiInterface::class.java)
            val call = apiInterface!!.userList
            call.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                    if (response.isSuccessful && response.body() != null) {

                        val gson = Gson()
                        var user: User? = null
                        try {
                            user = gson.fromJson(response.body()!!.string(), User::class.java)
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }

                        mutableLiveData!!.setValue(user)

                    }

                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                }
            })

            return mutableLiveData as MutableLiveData<User>
        }
}
