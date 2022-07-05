package com.omdeep.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omdeep.myapplication.databinding.LayoutUsersDataBinding
import com.omdeep.myapplication.model.userModel.JsonByUserItem

class UserAdapter(private val users : List<JsonByUserItem>) :RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutUsersDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user : JsonByUserItem = users[position]
        holder.binding.usersData = user
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class ViewHolder(var binding : LayoutUsersDataBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}