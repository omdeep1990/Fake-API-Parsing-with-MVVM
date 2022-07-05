package com.omdeep.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omdeep.myapplication.model.toDoModel.JsonByToDoItem
import com.omdeep.myapplication.repository.ToDoRepository

class ToDoViewModel : ViewModel() {

    var toDoList = MutableLiveData<ArrayList<JsonByToDoItem>>()

    fun getAllToDos() : MutableLiveData<ArrayList<JsonByToDoItem>> {
        var toDoRepository : ToDoRepository = ToDoRepository()
        toDoList = toDoRepository.getAllToDoList()
        return toDoList
    }
}