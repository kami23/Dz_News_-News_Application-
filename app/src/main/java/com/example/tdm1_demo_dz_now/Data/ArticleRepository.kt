package com.example.tdm1_demo_dz_now.Data


import androidx.lifecycle.LiveData
import androidx.annotation.WorkerThread
import com.example.tdm1_demo_dz_now.Artcile

/**
 * Abstracted Repository as promoted by the Architecture Guide.
 * https://developer.android.com/topic/libraries/architecture/guide.html
 */
class ArticleRepository(private val ArticleDao: ArticleDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allArticles: List<ArticleEntity> = ArticleDao.getArticles()

    // The suspend modifier tells the compiler that this must be called from a
    // coroutine or another suspend function.
    // This ensures that you're not doing any long running operations on the main
    // thread, blocking the UI.
     fun insert(Article: ArticleEntity) {
        ArticleDao.insert(Article)
    }

    companion object {
        // Singleton instantiation you already know and love
        @Volatile private var instance: ArticleRepository? = null

        fun getInstance(articleDao: ArticleDao) =
            instance ?: synchronized(this) {
                instance ?: ArticleRepository(articleDao).also { instance = it }
            }
    }
}

