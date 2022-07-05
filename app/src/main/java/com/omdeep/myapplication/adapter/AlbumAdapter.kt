package com.omdeep.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omdeep.myapplication.databinding.LayoutAlbumDataBinding
import com.omdeep.myapplication.model.albumModel.JsonByAlbumItem

class AlbumAdapter(private val albums : List<JsonByAlbumItem>) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutAlbumDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album : JsonByAlbumItem = albums[position]
        holder.binding.albumsModel = album
    }

    override fun getItemCount(): Int {
        return albums.size
    }
    inner class ViewHolder(var binding : LayoutAlbumDataBinding) : RecyclerView.ViewHolder(binding.root){

    }
}