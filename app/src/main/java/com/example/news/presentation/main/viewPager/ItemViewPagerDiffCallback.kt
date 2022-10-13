package com.example.news.presentation.main.viewPager

import androidx.recyclerview.widget.DiffUtil
import com.example.news.domain.models.Article

class ItemViewPagerDiffCallback: DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}