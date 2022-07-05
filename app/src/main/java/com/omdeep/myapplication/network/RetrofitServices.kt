package com.omdeep.myapplication.network

import com.omdeep.myapplication.model.albumModel.JsonByAlbum
import com.omdeep.myapplication.model.commentModel.JsonByComment
import com.omdeep.myapplication.model.postModel.JsonByPosts
import com.omdeep.myapplication.model.toDoModel.JsonByToDo
import com.omdeep.myapplication.model.userModel.JsonByUser
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface RetrofitServices {

    @GET("posts")
    fun getAllPosts() : Call<JsonByPosts>

    @GET("comments")
    fun getAllComments() : Call<JsonByComment>

    @GET("albums")
    fun getAllAlbums() : Call<JsonByAlbum>

    @GET("todos")
    fun getAllToDos() : Call<JsonByToDo>

    @GET("users")
    fun getAllUsers() : Call<JsonByUser>

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