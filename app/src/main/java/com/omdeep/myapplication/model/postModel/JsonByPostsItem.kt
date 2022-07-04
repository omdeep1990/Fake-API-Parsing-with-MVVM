package com.omdeep.myapplication.model.postModel


import com.google.gson.annotations.SerializedName

data class JsonByPostsItem(


    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: String
)