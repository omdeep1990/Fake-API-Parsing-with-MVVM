package com.omdeep.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omdeep.myapplication.databinding.LayoutToDoDataBinding
import com.omdeep.myapplication.model.toDoModel.JsonByToDoItem

class ToDoAdapter(private val toDos : List<JsonByToDoItem>) : RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutToDoDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val toDo : JsonByToDoItem = toDos[position]
        holder.binding.toDoDatas = toDo
    }

    override fun getItemCount(): Int {
        return toDos.size
    }

    class ViewHolder(var binding : LayoutToDoDataBinding) : RecyclerView.ViewHolder(binding.root){

    }
}