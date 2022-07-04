package com.omdeep.myapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omdeep.myapplication.model.commentModel.JsonByCommentItem
import com.omdeep.myapplication.repository.CommentRepository

class CommentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    var commentList = MutableLiveData<ArrayList<JsonByCommentItem>>()

    fun getAllComments() : MutableLiveData<ArrayList<JsonByCommentItem>>{
        var commentRepository : CommentRepository = CommentRepository()
        commentList = commentRepository.getAllCommentsList()
        return commentList
    }
}