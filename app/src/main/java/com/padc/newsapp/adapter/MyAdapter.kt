package com.padc.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.padc.newsapp.data.vos.Article
import com.padc.newsapp.databinding.NewsItemViewBinding
import com.padc.newsapp.ui.viewholder.NewViewHolder

class MyAdapter : ListAdapter<Article,NewViewHolder>(DiffCallback) {
    companion object DiffCallback :DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.title == newItem.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        return NewViewHolder(NewsItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        val article = getItem(position)
        holder.bindData(article)
    }
}