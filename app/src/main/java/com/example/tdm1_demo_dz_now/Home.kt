package com.example.tdm1_demo_dz_now

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
import android.content.Intent
class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bg_image.setOnClickListener {
            val intent = Intent(this, news::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}
