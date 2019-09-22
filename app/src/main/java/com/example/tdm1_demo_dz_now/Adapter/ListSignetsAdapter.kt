package com.example.tdm1_demo_dz_now.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.tdm1_demo_dz_now.Interface.ItemClickListener
import com.example.tdm1_demo_dz_now.Model.Article
import com.example.tdm1_demo_dz_now.Model.WebSite
import com.example.tdm1_demo_dz_now.R

class ListSignetsAdapter(private  val context: Context,private val articles:List<String>):
    androidx.recyclerview.widget.RecyclerView.Adapter<ListSignetsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSignetsViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val itemView=inflater.inflate(R.layout.one_signet_layout,parent,false)
        return ListSignetsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ListSignetsViewHolder, position: Int) {
        holder.title.text=articles[position]!!
        holder.setItemClickListener(object: ItemClickListener
        {

            override fun onClick(view: View, position: Int) {
                Toast.makeText(context,"Will be implement",Toast.LENGTH_SHORT).show()
            }

        })
    }
}