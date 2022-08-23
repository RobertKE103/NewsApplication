package com.example.news.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.news.R
import com.example.news.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private var mBinding: FragmentDetailsBinding ?= null
    private val binding get() = mBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}