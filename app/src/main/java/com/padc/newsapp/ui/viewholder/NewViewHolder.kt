package com.padc.newsapp.ui.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.padc.newsapp.data.vos.Article
import kotlinx.android.synthetic.main.news_item_view.view.*

class NewViewHolder(itemView: View) : BaseViewHolder<Article>(itemView) {
    override fun bindData(data: Article) {
        mData =  data

        itemView.tvTitle.text = data.title
        itemView.tvDescription.text = data.description

        Glide.with(itemView.context)
            .load(data.urlToImage)
            .into(itemView.ivImage)
    }

}