package com.omdeep.myapplication.network

import com.omdeep.myapplication.model.postModel.JsonByPosts
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface RetrofitServices {

    @GET("posts")
    fun getAllPosts() : Call<JsonByPosts>

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        var retrofitServices : RetrofitServices? = null
        fun getInstance() : RetrofitServices {
            if (retrofitServices == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitServices = retrofit.create(RetrofitServices::class.java)
            }
            return retrofitServices!!
        }
    }
}