package com.omdeep.myapplication.model.commentModel


import com.google.gson.annotations.SerializedName

data class JsonByCommentItem(

    @SerializedName("body")
    val body: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("postId")
    val postId: String

)