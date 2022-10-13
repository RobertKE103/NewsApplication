package com.example.news.presentation.main.viewPager

import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.news.R
import com.example.news.databinding.ItemListNewsBinding
import com.example.news.domain.models.Article

class ItemViewPagerAdapter(private val application: Application) : ListAdapter<Article,
        ItemViewPagerAdapter.GeneralViewHolder>(ItemViewPagerDiffCallback()) {

    var onNewsItemClickListener: ((Article) -> Unit)? = null

    class GeneralViewHolder(
        private val binding: ItemListNewsBinding,
        private val application: Application,
    ) : ViewHolder(binding.root) {
        fun bind(data: Article) {
            with(binding) {
                articleData.text = data.publishedAt
                articleTitle.text = data.title
                Glide.with(application)
                    .load(data.urlToImage)
                    .centerCrop()
                    .placeholder(R.drawable.search)
                    .into(imgNews)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListNewsBinding.inflate(inflater, parent, false)
        return GeneralViewHolder(binding, application)
    }

    override fun onBindViewHolder(holder: GeneralViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}