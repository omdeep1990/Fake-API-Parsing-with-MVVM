package com.omdeep.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omdeep.myapplication.model.userModel.JsonByUserItem
import com.omdeep.myapplication.repository.UserRepository

class UserViewModel : ViewModel() {

    var userList = MutableLiveData<ArrayList<JsonByUserItem>>()

    fun getAllUsers() : MutableLiveData<ArrayList<JsonByUserItem>> {
        var userRepository : UserRepository = UserRepository()
        userList = userRepository.getAllUserList()
        return userList
    }
}