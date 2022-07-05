package com.omdeep.myapplication.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.omdeep.myapplication.model.toDoModel.JsonByToDo
import com.omdeep.myapplication.model.toDoModel.JsonByToDoItem
import com.omdeep.myapplication.network.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ToDoRepository {

    val toDoList = MutableLiveData<ArrayList<JsonByToDoItem>>()

    fun getAllToDoList() : MutableLiveData<ArrayList<JsonByToDoItem>> {
        val api = RetrofitServices.getInstance().getAllToDos()

        api.enqueue(object : Callback<JsonByToDo?> {
            override fun onResponse(call: Call<JsonByToDo?>, response: Response<JsonByToDo?>) {
                response.let {
                    toDoList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<JsonByToDo?>, t: Throwable) {
                Log.d("TAG", "Failure Occurred"+ t.localizedMessage)
            }
        })
        return toDoList
    }
}