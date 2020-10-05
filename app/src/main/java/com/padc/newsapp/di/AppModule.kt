package com.padc.newsapp.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.padc.newsapp.BuildConfig
import com.padc.newsapp.network.ApiService
import com.padc.newsapp.repository.NewsRepository
import com.padc.newsapp.util.BASE_URL
import com.padc.newsapp.data.models.NewsRemoteDataSource
import com.padc.newsapp.persistence.dao.NewDao
import com.padc.newsapp.persistence.db.NewDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .apply {
            if (BuildConfig.DEBUG) client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
            )
        }
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()


    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideRemoteDataSource(apiService: ApiService) =
        NewsRemoteDataSource(apiService)

    @Singleton
    @Provides
    fun provideNewsRepository(newsRemoteDataSource: NewsRemoteDataSource,newDao: NewDao) = NewsRepository(newsRemoteDataSource,newDao)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = NewDatabase.getDatabase(context)

    @Singleton
    @Provides
    fun provideNewDao(db:NewDatabase) = db.newsDao()
}



