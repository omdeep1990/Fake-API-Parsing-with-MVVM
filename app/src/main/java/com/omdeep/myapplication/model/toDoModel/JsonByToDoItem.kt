package com.omdeep.myapplication.model.toDoModel


import com.google.gson.annotations.SerializedName

data class JsonByToDoItem(

    @SerializedName("completed")
    val completed: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("userId")
    val userId: String
)