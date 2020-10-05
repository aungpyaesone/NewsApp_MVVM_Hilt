package com.padc.newsapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.padc.newsapp.repository.NewsRepository

class NewsViewModel @ViewModelInject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    val news = repository.getAllNewsFromDataSource()
}