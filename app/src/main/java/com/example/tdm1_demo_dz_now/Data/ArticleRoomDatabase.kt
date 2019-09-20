package com.example.tdm1_demo_dz_now.Data

import androidx.sqlite.db.SupportSQLiteDatabase
import android.content.Context
import androidx.room.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * This is the backend. The database. This used to be done by the OpenHelper.
 * The fact that this has very few comments emphasizes its coolness.
 */
@Database(entities = [ArticleEntity::class], version = 4)
abstract class ArticleRoomDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao

    companion object {
        private var instance: ArticleRoomDatabase? = null

        fun getDatabase(context: Context):ArticleRoomDatabase?{
            if (instance == null){
                instance = Room.
                    databaseBuilder(context.applicationContext, ArticleRoomDatabase::class.java,"article.db").fallbackToDestructiveMigration()
                    .build()
         }
            return instance

        }
        fun destroyInstance(){
            instance = null
        }
    }
}
