package com.example.listviewhw

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listviewhw.User

class UserViewModel: ViewModel() {

    var userList: MutableLiveData<MutableList<User>> = MutableLiveData()

    fun getListUsers() = userList
}