package com.padc.newsapp.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "article")
data class Article(
    @SerializedName("author")
    var author: String? =null,

    @SerializedName("content")
    var content: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("publishedAt")
    var publishedAt: String? = null,
    
    @Embedded
    @SerializedName("source")
    var source: Source? = null,

    @PrimaryKey
    @SerializedName("title")
    var title: String,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("urlToImage")
    var urlToImage: String? = null
)