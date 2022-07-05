package com.omdeep.myapplication.model.albumModel


import com.google.gson.annotations.SerializedName

data class JsonByAlbumItem(

    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("userId")
    val userId: String

)