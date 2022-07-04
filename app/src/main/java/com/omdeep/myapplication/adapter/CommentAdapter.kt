package com.omdeep.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omdeep.myapplication.databinding.LayoutCommentDataBinding
import com.omdeep.myapplication.model.commentModel.JsonByCommentItem

class CommentAdapter(private val comments : List<JsonByCommentItem>) : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutCommentDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comment : JsonByCommentItem = comments[position]
        holder.binding.commentsModel = comment
    }

    override fun getItemCount(): Int {
        return comments.size
    }
    inner class ViewHolder(var binding : LayoutCommentDataBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}