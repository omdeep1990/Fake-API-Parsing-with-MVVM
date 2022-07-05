package com.omdeep.myapplication.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.omdeep.myapplication.model.userModel.JsonByUser
import com.omdeep.myapplication.model.userModel.JsonByUserItem
import com.omdeep.myapplication.network.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    val userList = MutableLiveData<ArrayList<JsonByUserItem>>()

    fun getAllUserList() : MutableLiveData<ArrayList<JsonByUserItem>> {
        val api = RetrofitServices.getInstance().getAllUsers()

        api.enqueue(object : Callback<JsonByUser?> {
            override fun onResponse(call: Call<JsonByUser?>, response: Response<JsonByUser?>) {
                response.let {
                    userList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<JsonByUser?>, t: Throwable) {
                Log.d("TAG", "Failure Occurred"+ t.localizedMessage)
            }
        })
        return userList
    }
}