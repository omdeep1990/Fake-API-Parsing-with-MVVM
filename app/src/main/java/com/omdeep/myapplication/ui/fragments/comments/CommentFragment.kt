package com.omdeep.myapplication.ui.fragments.comments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.omdeep.myapplication.adapter.CommentAdapter
import com.omdeep.myapplication.databinding.FragmentHomeBinding
import com.omdeep.myapplication.viewModel.CommentViewModel

class CommentFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: CommentAdapter
    private lateinit var mainViewModel : CommentViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainViewModel =
            ViewModelProvider(this).get(CommentViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //TODO: MyComment Data Display Screen
        binding.recyclerView.layoutManager = GridLayoutManager(context, 1)

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        mainViewModel.getAllComments().observe(viewLifecycleOwner, Observer {
            adapter = CommentAdapter(it)
            binding.recyclerView.adapter = adapter
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}