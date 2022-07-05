package com.omdeep.myapplication.ui.fragments.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.omdeep.myapplication.R
import com.omdeep.myapplication.adapter.UserAdapter
import com.omdeep.myapplication.databinding.FragmentUserBinding
import com.omdeep.myapplication.viewModel.UserViewModel

class UserFragment : Fragment() {
    private var _binding : FragmentUserBinding? = null
    private lateinit var adapter : UserAdapter
    private lateinit var mainViewModel : UserViewModel

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
    ): View {
        mainViewModel = ViewModelProvider(this).get(UserViewModel::class.java)



        _binding = FragmentUserBinding.inflate(layoutInflater, container, false)
        val root: View = binding.root

        //TODO: MyPost Data Display Screen
        binding.recyclerView.layoutManager = GridLayoutManager(context, 1)
        // Inflate the layout for this fragment

        mainViewModel.getAllUsers().observe(viewLifecycleOwner, Observer {
            adapter = UserAdapter(it)
            binding.recyclerView.adapter = adapter
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}