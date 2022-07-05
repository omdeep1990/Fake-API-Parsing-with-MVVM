package com.omdeep.myapplication.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.omdeep.myapplication.model.albumModel.JsonByAlbum
import com.omdeep.myapplication.model.albumModel.JsonByAlbumItem
import com.omdeep.myapplication.network.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumRepository {

    val albumList = MutableLiveData<ArrayList<JsonByAlbumItem>>()

    fun getAllAlbumsList() : MutableLiveData<ArrayList<JsonByAlbumItem>> {
        val api = RetrofitServices.getInstance().getAllAlbums()

        api.enqueue(object : Callback<JsonByAlbum?> {
            override fun onResponse(call: Call<JsonByAlbum?>, response: Response<JsonByAlbum?>) {
                response.let {
                    albumList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<JsonByAlbum?>, t: Throwable) {
                Log.d("TAG", "Failure Occurred"+ t.localizedMessage)
            }
        })
        return albumList
    }
}