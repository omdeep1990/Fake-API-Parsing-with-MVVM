package com.omdeep.myapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omdeep.myapplication.model.postModel.JsonByPostsItem
import com.omdeep.myapplication.repository.PostRepository

class PostViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text

    var postList = MutableLiveData<ArrayList<JsonByPostsItem>>()

    fun getAllPosts() : MutableLiveData<ArrayList<JsonByPostsItem>> {
        var postRepository : PostRepository = PostRepository()
        postList = postRepository.getAllPostsList()
        return postList
    }
}