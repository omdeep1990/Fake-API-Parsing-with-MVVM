package com.omdeep.myapplication.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.omdeep.myapplication.model.postModel.JsonByPosts
import com.omdeep.myapplication.model.postModel.JsonByPostsItem
import com.omdeep.myapplication.network.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository {
    val postList = MutableLiveData<ArrayList<JsonByPostsItem>>()

    fun getAllPostsList() : MutableLiveData<ArrayList<JsonByPostsItem>> {
        val api = RetrofitServices.getInstance().getAllPosts()

        api.enqueue(object : Callback<JsonByPosts?> {
            override fun onResponse(call: Call<JsonByPosts?>, response: Response<JsonByPosts?>) {
                response.let {
                    postList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<JsonByPosts?>, t: Throwable) {
                Log.d("TAG", "Failure Occurred"+ t.localizedMessage)
            }
        })
    return postList
    }
}