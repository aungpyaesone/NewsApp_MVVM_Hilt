package com.padc.newsapp.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padc.newsapp.data.vos.Article

@Dao
interface NewDao {
    @Query("select * from article")
    fun getAllArticle () : LiveData<List<Article>>

//    @Query("select * from article where title = :title")
//    fun getArticleByTitle(title:String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(articles: List<Article>)

}