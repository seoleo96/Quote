package com.example.quote.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.quote.base.App
import com.example.quote.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        homeViewModel = (activity?.application as App).viewModel
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.load.setOnClickListener {
            homeViewModel.fetchQuotes()
        }

        homeViewModel.apply {

            fetchQuotes()

            successObserve(viewLifecycleOwner) { quoteUIModel ->
                binding.textHome.text = quoteUIModel
            }

            progressObserve(viewLifecycleOwner){
                binding.progress.isVisible = it
                binding.textHome.isGone = it
                binding.load.isGone = it
            }

            errorObserve(viewLifecycleOwner){
                Snackbar.make(view, it, Snackbar.LENGTH_SHORT).show()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}