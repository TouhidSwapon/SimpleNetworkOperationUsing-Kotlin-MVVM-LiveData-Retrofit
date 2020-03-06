package com.swapon.simplenetworkoperationusingmvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import com.swapon.simplenetworkoperationusingmvvm.model.pojo.User
import com.swapon.simplenetworkoperationusingmvvm.model.repository.UserRepository

class UserActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository: UserRepository


    val allUsers: LiveData<User>
        get() = userRepository.userData

    init {
        userRepository = UserRepository(application)
    }

}
