package com.example.tdm1_demo_dz_now.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.tdm1_demo_dz_now.Interface.ItemClickListener
import kotlinx.android.synthetic.main.news_layout.view.*
import kotlinx.android.synthetic.main.source_news_layout.view.*
import java.text.FieldPosition

class ListNewsViewHolder (itemView:View):RecyclerView.ViewHolder(itemView) ,View.OnClickListener {

    private lateinit var itemClickListener: ItemClickListener
    var news_title=itemView.news_title
    var description=itemView.news_des
    var source=itemView.news_src
    init {
        itemView.setOnClickListener(this)
    }
    fun setItemClickListener(itemClickListener: ItemClickListener){
        this.itemClickListener=itemClickListener
    }
    override fun onClick(v:View?){
        itemClickListener.onClick(v!!,adapterPosition)
    }



}