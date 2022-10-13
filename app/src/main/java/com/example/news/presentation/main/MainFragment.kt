package com.example.news.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.news.databinding.FragmentMainBinding
import com.example.news.presentation.main.viewPager.ViewPagerAdapter
import com.example.news.presentation.main.viewPager.general.GeneralFragment
import com.example.news.presentation.main.viewPager.sports.SportFragment
import com.example.news.presentation.main.viewPager.technology.TechnologyFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding ?= null
    private val binding get() = _binding!!

    private val viewPagerAdapter by lazy { ViewPagerAdapter(this, listFragments) }
    private lateinit var viewPager: ViewPager2
    private lateinit var tableLayout: TabLayout

    private val viewModel by viewModel<MainFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }



    override fun onPause() {
        super.onPause()
        viewPager.adapter = null
    }


    private fun setupViewPager() {
        viewPager = binding.myViewPager
        viewPager.adapter = viewPagerAdapter
        tableLayout = binding.tableLayout
        TabLayoutMediator(tableLayout, viewPager) { tab, position ->
            tab.text = category[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private val category = listOf(
            "общее",
            "технологии",
            "спорт"
        )

        private val listFragments = listOf(
            GeneralFragment(), TechnologyFragment(), SportFragment()
        )

    }

}