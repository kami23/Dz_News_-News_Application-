package com.example.tdm1_demo_dz_now.Adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.example.tdm1_demo_dz_now.Interface.ItemClickListener
import kotlinx.android.synthetic.main.source_news_layout.view.*
import java.text.FieldPosition

class ListSourceViewHolder (itemView:View): androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) ,View.OnClickListener {

    private lateinit var itemClickListener: ItemClickListener
    var source_title=itemView.source_name_news
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