package com.example.news.presentation.main.viewPager.sports

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.news.R
import com.example.news.databinding.FragmentSportBinding
import com.example.news.presentation.details.DetailsFragment
import com.example.news.presentation.main.viewPager.ItemViewPagerAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SportFragment : Fragment() {

    private var _binding: FragmentSportBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ItemViewPagerAdapter
    private val viewModel by viewModel<SportViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSportBinding.inflate(layoutInflater, container, false)
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

        adapter.onNewsItemClickListener = {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, DetailsFragment.newInstance(it))
                .addToBackStack(null)
                .commit()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    companion object {
        const val category = "sports"
    }

}