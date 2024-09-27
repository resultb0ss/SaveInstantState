package com.example.listviewhw

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listviewhw.User

class UserViewModel: ViewModel() {

    val users: MutableList<User> = mutableListOf()
    val userList: MutableLiveData<MutableList<User>> by lazy { MutableLiveData<MutableList<User>>() }

    fun getListUsers() = userList
}