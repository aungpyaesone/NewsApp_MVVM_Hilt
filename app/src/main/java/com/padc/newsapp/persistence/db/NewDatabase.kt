package com.padc.newsapp.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padc.newsapp.data.vos.Article
import com.padc.newsapp.persistence.dao.NewDao

@Database (entities = [Article::class],exportSchema = false,version = 1)
abstract class NewDatabase : RoomDatabase() {
    abstract fun newsDao() : NewDao

    companion object{
        @Volatile private var instance: NewDatabase? = null
        fun getDatabase(context: Context): NewDatabase =
            instance ?: synchronized(this){
                instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, NewDatabase::class.java, "new_database")
                .fallbackToDestructiveMigration()
                .build()
    }
}