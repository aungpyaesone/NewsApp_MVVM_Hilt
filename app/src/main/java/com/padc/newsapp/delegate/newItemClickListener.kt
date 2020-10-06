package com.padc.newsapp.delegate

import com.padc.newsapp.data.vos.Article

interface newItemClickListener {
    fun onTouchItem(article:Article)
}