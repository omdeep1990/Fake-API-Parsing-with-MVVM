package com.omdeep.myapplication.ui.fragments.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.omdeep.myapplication.adapter.AlbumAdapter
import com.omdeep.myapplication.databinding.FragmentSlideshowBinding
import com.omdeep.myapplication.viewModel.AlbumViewModel

class AlbumFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null
    private lateinit var adapter : AlbumAdapter
    private lateinit var mainViewModel : AlbumViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainViewModel =
            ViewModelProvider(this).get(AlbumViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //TODO: MyComment Data Display Screen
        binding.recyclerView.layoutManager = GridLayoutManager(context, 1)
//
////        val textView: TextView = binding.textSlideshow
////        slideshowViewModel.text.observe(viewLifecycleOwner) {
////            textView.text = it
////        }
        mainViewModel.getAllAlbums().observe(viewLifecycleOwner, Observer {
            adapter = AlbumAdapter(it)
            binding.recyclerView.adapter = adapter
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}