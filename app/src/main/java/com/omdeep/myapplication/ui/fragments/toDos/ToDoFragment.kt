package com.omdeep.myapplication.ui.fragments.toDos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.omdeep.myapplication.R
import com.omdeep.myapplication.adapter.ToDoAdapter
import com.omdeep.myapplication.databinding.FragmentToDoBinding
import com.omdeep.myapplication.viewModel.ToDoViewModel

class ToDoFragment : Fragment() {
    private var _binding : FragmentToDoBinding? = null
    private lateinit var adapter: ToDoAdapter
    private lateinit var mainViewModel: ToDoViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainViewModel = ViewModelProvider(this).get(ToDoViewModel::class.java)

        _binding = FragmentToDoBinding.inflate(inflater, container, false)
        val root : View = binding.root

        //TODO: MyTODo Data Display Screen
        binding.recyclerView.layoutManager = GridLayoutManager(context, 1)

        mainViewModel.getAllToDos().observe(viewLifecycleOwner, Observer {
            adapter = ToDoAdapter(it)
            binding.recyclerView.adapter = adapter
        })
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


