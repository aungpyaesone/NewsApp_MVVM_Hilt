package com.padc.newsapp.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers

fun <T,A> performOperation(
    databaseQuery : () -> LiveData<T>,
    networkCall: suspend ()-> Resource<A>,
    savecallResult : suspend(A) -> Unit) : LiveData<Resource<T>> =

    liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val source = databaseQuery.invoke().map { Resource.success(it) }
        emitSource(source)

        val responseStatus = networkCall.invoke()
        if(responseStatus.status == Resource.Status.SUCCESS){
           savecallResult(responseStatus.data!!)
           // emit(responseStatus)
        }
        else if(responseStatus.status == Resource.Status.ERROR){
            emit(Resource.error(responseStatus.message!!))
            emitSource(source)
        }
    }
