package com.example.news.presentation.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.news.R
import com.example.news.databinding.FragmentDetailsBinding
import com.example.news.domain.models.Article

class DetailsFragment : Fragment() {

    private lateinit var article: Article
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArguments()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(article)
        setOnClickButton()

        binding.iconBack.setOnClickListener {

        }

    }

    private fun setOnClickButton() {
        binding.articleVisitSite.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(article.url))
            startActivity(intent)
        }
    }

    private fun bind(data: Article) {
        with(binding) {
            articleDetailsTitle.text = data.title
            articleDetailsDescription.text = data.description
            Glide.with(this@DetailsFragment)
                .load(data.urlToImage)
                .centerCrop()
                .placeholder(R.drawable.search)
                .into(headerImage)
        }
    }

    private fun parseArguments() {
        requireArguments().getParcelable<Article>(KEY_DETAILS)?.let {
            article = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val KEY_DETAILS = "details"

        fun newInstance(article: Article): DetailsFragment {
            return DetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_DETAILS, article)
                }
            }

        }
    }

}