package com.omdeep.myapplication.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.omdeep.myapplication.model.commentModel.JsonByComment
import com.omdeep.myapplication.model.commentModel.JsonByCommentItem
import com.omdeep.myapplication.network.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentRepository {

    val commentList = MutableLiveData<ArrayList<JsonByCommentItem>>()

    fun getAllCommentsList() : MutableLiveData<ArrayList<JsonByCommentItem>> {
        val api = RetrofitServices.getInstance().getAllComments()

        api.enqueue(object : Callback<JsonByComment?> {
            override fun onResponse(
                call: Call<JsonByComment?>,
                response: Response<JsonByComment?>
            ) {
                response.let {
                    commentList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<JsonByComment?>, t: Throwable) {
                Log.d("TAG", "Failure Occurred"+ t.localizedMessage)
            }
        })
        return commentList
    }
}