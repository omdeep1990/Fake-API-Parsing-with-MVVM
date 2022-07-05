package com.omdeep.myapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omdeep.myapplication.model.albumModel.JsonByAlbumItem
import com.omdeep.myapplication.repository.AlbumRepository

class AlbumViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }
    val text: LiveData<String> = _text

    var albumList = MutableLiveData<ArrayList<JsonByAlbumItem>>()

    fun getAllAlbums() : MutableLiveData<ArrayList<JsonByAlbumItem>> {
        var albumRepository : AlbumRepository = AlbumRepository()
        albumList = albumRepository.getAllAlbumsList()
        return albumList
    }
}