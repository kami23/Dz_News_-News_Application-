package com.example.tdm1_demo_dz_now

import android.app.AlertDialog
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.view.View


class customCard @JvmOverloads constructor(
     context: Context,
    attrs: AttributeSet? = null) : LinearLayout(context, attrs) {


        private var tv_title : TextView
    private var imageView: ImageView

    init {
        val inflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.card_custom_view,this , true)
        tv_title=view.findViewById(R.id.tv_title)
        imageView= view.findViewById(R.id.img_news)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.customCard)
        imageView.setImageDrawable(attributes.getDrawable(R.styleable.customCard_image))
        tv_title.text = attributes.getString(R.styleable.customCard_text)
        attributes.recycle()


    }


}

