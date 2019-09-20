package com.example.tdm1_demo_dz_now.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tdm1_demo_dz_now.Data.ArticleDao
import com.example.tdm1_demo_dz_now.Data.ArticleEntity

@Database(entities = [(ArticleEntity::class)],version=1)
abstract class ApplicationDB : RoomDatabase() {
    abstract fun articleDao() : ArticleDao
}