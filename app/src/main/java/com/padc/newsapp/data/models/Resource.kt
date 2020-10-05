package com.padc.newsapp.data.models

data class Resource<out T>(val status: Status, val data: T?, val message:String?) {
    enum class Status{
        SUCCESS,
        ERROR,
        LOADING
    }
    companion object{
        fun <T> success(data:T) : Resource<T> {
            return Resource(
                Status.SUCCESS,
                data,
                null
            )
        }
        fun <T> error(message:String) : Resource<T> {
            return Resource(
                Status.ERROR,
                null,
                message
            )
        }
        fun <T> loading(data : T? = null): Resource<T> {
            return Resource(
                Status.LOADING,
                data,
                null
            )
        }
    }

}

//sealed class Status{
//    data class Success<T>(val data:T) : Status()
//    data class Error(val message: String?): Status()
//    object Loading : Status()
//}