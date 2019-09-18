package com.example.tdm1_demo_dz_now.Adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tdm1_demo_dz_now.Interface.ItemClickListener
import com.example.tdm1_demo_dz_now.Model.Article
import com.example.tdm1_demo_dz_now.Model.WebSite
import com.example.tdm1_demo_dz_now.R

class ListNewsAdapter(private val articleList :List<Article>, private  val context: Context):RecyclerView.Adapter<ListNewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNewsViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val itemView=inflater.inflate(R.layout.news_layout,parent,false)
        return ListNewsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ListNewsViewHolder, position: Int) {
       // Picasso.with(context).load(articleList[position].urlToImage)

        if (articleList[position].title!!.length>65) {
            holder.news_title.text = articleList[position].title!!.substring(0, 65) + "..."
        }else {
            holder.news_title.text = articleList[position].title!!
        }




        holder.setItemClickListener(object: ItemClickListener
        {
            override fun onClick(view: View, position: Int) {
                Toast.makeText(context,"Will be implement",Toast.LENGTH_SHORT).show()
            }

        })
    }
}