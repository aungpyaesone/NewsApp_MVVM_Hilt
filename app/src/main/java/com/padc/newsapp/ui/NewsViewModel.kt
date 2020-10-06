package com.padc.newsapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.padc.newsapp.data.models.Resource
import com.padc.newsapp.data.vos.Article
import com.padc.newsapp.repository.NewsRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsViewModel @ViewModelInject constructor(
    private val repository: NewsRepository
) : ViewModel() {
    private val _status = MutableLiveData<Resource.Status>()
    val status : LiveData<Resource.Status>
    get() = _status

    val _liveNews = MutableLiveData<List<Article>>()
    val liveNewsList : LiveData<List<Article>>
    get() = _liveNews

    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch {
            _status.value = Resource.Status.LOADING
            try{
                repository.getAllNewsFromDataSource().map {
                    it.data
                }.map {
                    it?.let {
                        _liveNews.value = it
                        _status.value = Resource.Status.SUCCESS
                    }
                }

            }catch (e: Exception){
                _status.value = Resource.Status.ERROR
                _liveNews.value = arrayListOf()
            }

        }

        }


}