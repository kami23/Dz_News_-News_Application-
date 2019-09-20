package com.example.tdm1_demo_dz_now.Data


import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tdm1_demo_dz_now.R

class ArticleListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var articles = emptyList<ArticleEntity>() // Cached copy of words

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val articleItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return ArticleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val current = articles[position]
        holder.articleItemView.text = current.title
    }

    internal fun setWords(words: List<ArticleEntity>) {
        this.articles = words
        notifyDataSetChanged()
    }

    override fun getItemCount() = articles.size
}


