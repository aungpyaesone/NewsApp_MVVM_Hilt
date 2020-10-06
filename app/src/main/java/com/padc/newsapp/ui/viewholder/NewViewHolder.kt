package com.padc.newsapp.ui.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.padc.newsapp.data.vos.Article
import com.padc.newsapp.databinding.NewsItemViewBinding
import com.padc.newsapp.delegate.newItemClickListener
import kotlinx.android.synthetic.main.news_item_view.view.*

class NewViewHolder(private val binding: NewsItemViewBinding) : BaseViewHolder<Article>(binding.root) {
    override fun bindData(data: Article) {
        mData =  data
        binding.article = data
        binding.executePendingBindings()

//        itemView.tvTitle.text = data.title
//        itemView.tvDescription.text = data.description
//
//        Glide.with(itemView.context)
//            .load(data.urlToImage)
//            .into(itemView.ivImage)
//
//        itemView.setOnClickListener {
//            mData?.let {
//                mDelegate.onTouchItem(it)
//            }
//        }
    }


}