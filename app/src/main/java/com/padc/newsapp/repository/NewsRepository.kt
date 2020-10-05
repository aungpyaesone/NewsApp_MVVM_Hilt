package com.padc.newsapp.repository

import android.util.Log
import com.padc.newsapp.data.models.NewsRemoteDataSource
import com.padc.newsapp.data.models.performOperation
import com.padc.newsapp.persistence.dao.NewDao
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsRemoteDataSource: NewsRemoteDataSource,
                                         private val localDataSource : NewDao
)  {

    fun getAllNewsFromDataSource() = performOperation(databaseQuery = {
        localDataSource.getAllArticle()
    },
        networkCall = {
        newsRemoteDataSource.getAllNews()
    },
    savecallResult ={
        localDataSource.insertAll(it.articles)
    } )
}