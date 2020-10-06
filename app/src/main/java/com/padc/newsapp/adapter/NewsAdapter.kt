package com.padc.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.newsapp.data.vos.Article
import com.padc.newsapp.databinding.NewsItemViewBinding
import com.padc.newsapp.delegate.newItemClickListener
import com.padc.newsapp.ui.viewholder.BaseViewHolder
import com.padc.newsapp.ui.viewholder.NewViewHolder

class NewsAdapter(private val mDelegate:newItemClickListener) : BaseAdapter<BaseViewHolder<Article>,Article>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Article> {
        //val v = LayoutInflater.from(parent.context).inflate(R.layout.news_item_view,parent,false)
        return NewViewHolder(NewsItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }
}