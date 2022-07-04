package com.omdeep.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omdeep.myapplication.databinding.LayoutPostDataBinding
import com.omdeep.myapplication.model.postModel.JsonByPostsItem

class PostAdapter(private val posts : List<JsonByPostsItem>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutPostDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post : JsonByPostsItem = posts[position]
        //TODO: Fifrst Method to display on the screen
        holder.binding.postsModel = post
        //TODO: Second method to display on the screen
//        holder.binding.postId.text = post.id
//        holder.binding.tvTitle.text = post.title
//        holder.binding.postUserId.text = post.userId
//        holder.binding.postBody.text = post.body

    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class ViewHolder(var binding : LayoutPostDataBinding) : RecyclerView.ViewHolder(binding.root){

    }
}