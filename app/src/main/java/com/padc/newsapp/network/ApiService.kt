package com.padc.newsapp.network

import com.padc.newsapp.data.vos.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
 @GET("everything")
 suspend fun getAllNews(@Query(value = "q")q:String,
                        @Query(value = "from")from:String,
                        @Query(value = "to")to:String,
                        @Query(value = "sortBy")sortBy:String,
                        @Query(value = "apiKey")apiKey:String
 ): Response<NewsResponse>
}