package com.example.news.presentation.search

import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.news.R
import com.example.news.databinding.FragmentSearchBinding
import com.example.news.presentation.details.DetailsFragment
import com.example.news.presentation.main.viewPager.ItemViewPagerAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private val viewModel by viewModel<SearchFragmentViewModel>()
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ItemViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRv()
        setOnEditorActionListener()
        onFocusChangeListener()
        setOnClickListener()
    }

    override fun onResume() {
        super.onResume()
        checkEditText()
    }

    private fun checkEditText(){
        val data = binding.inputKeyWord.text
        if (!data.isNullOrEmpty()){
            getNews(data.toString())
            binding.noNewsText.visibility = View.GONE
        }
    }


    private fun setOnClickListener() {
        binding.inputKeyWord.setOnClickListener {
            binding.inputKeyWord.isCursorVisible = true
        }
    }

    private fun onFocusChangeListener() {
        binding.inputKeyWord.onFocusChangeListener =
            View.OnFocusChangeListener { _, p1 ->
                binding.inputKeyWord.isCursorVisible = p1
            }
    }

    private fun setOnEditorActionListener() {
        binding.inputKeyWord.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                getNews(v.text.toString())
                cursorFalse()
                removeKeyboard()
                binding.noNewsText.visibility = View.GONE
                return@OnEditorActionListener true
            }
            false
        })
    }

    private fun removeKeyboard() {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.inputKeyWord.windowToken, 0)
    }


    private fun cursorFalse() {
        binding.inputKeyWord.isCursorVisible = false
    }

    private fun getNews(key: String) {
        viewModel.getNews(key)
        viewModel.listNews.observe(viewLifecycleOwner) {
            adapter.submitList(it.body()!!.articles)
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

}