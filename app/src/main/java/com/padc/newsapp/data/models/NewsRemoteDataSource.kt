package com.padc.newsapp.data.models

import com.padc.newsapp.network.ApiService
import com.padc.newsapp.util.*
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(private val apiService: ApiService) : BaseDataSource(){

    suspend fun getAllNews() = getResult { apiService.getAllNews(
        Q, FROM, TO, SORT_BY, API_KEY
    )
    }

}