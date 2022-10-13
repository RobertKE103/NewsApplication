package com.example.news.presentation.main.viewPager.technology

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.news.R
import com.example.news.databinding.FragmentSportBinding
import com.example.news.databinding.FragmentTechnologyBinding
import com.example.news.presentation.main.viewPager.ItemViewPagerAdapter
import com.example.news.presentation.main.viewPager.sports.SportViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TechnologyFragment : Fragment() {

    private var _binding: FragmentTechnologyBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ItemViewPagerAdapter
    private val viewModel by viewModel<TechnologyViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTechnologyBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRv()
        try {
            viewModel.getNews()
            viewModel.listNews.observe(viewLifecycleOwner) {
                val listNews = it.body()?.articles
                adapter.submitList(listNews)
            }
        } catch (e: Exception) {
            Log.d("exception", e.message.toString())
        }

    }

    private fun setupRv() {
        val recyclerView = binding.recV
        adapter = ItemViewPagerAdapter(requireActivity().application)
        recyclerView.adapter = adapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        const val category = "technology"
    }


}