package com.omdeep.myapplication.ui.fragments.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.omdeep.myapplication.adapter.PostAdapter
import com.omdeep.myapplication.databinding.FragmentGalleryBinding
import com.omdeep.myapplication.viewModel.PostViewModel

class PostFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private lateinit var adapter : PostAdapter
    private lateinit var postViewModel : PostViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        postViewModel =
            ViewModelProvider(this).get(PostViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //TODO: MyPost Data Display Screen
        binding.recyclerView.layoutManager = GridLayoutManager(context, 1)

//        val textView: TextView = binding.textGallery
//        postViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        postViewModel.getAllPosts().observe(viewLifecycleOwner, Observer {
            adapter = PostAdapter(it)
            binding.recyclerView.adapter = adapter
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}