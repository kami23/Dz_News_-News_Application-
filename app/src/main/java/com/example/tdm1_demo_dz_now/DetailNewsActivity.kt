package com.example.tdm1_demo_dz_now

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.AlertDialog
import android.webkit.WebView
import android.webkit.WebViewClient
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_detail_news.*

class DetailNewsActivity : AppCompatActivity() {

    lateinit var  alertDialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        alertDialog=SpotsDialog(this)
        alertDialog.show()

        //WEB VIEW
        web_View.settings.javaScriptEnabled=true
        web_View.webViewClient= WebViewClient()
        web_View.webViewClient=object:WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                alertDialog.dismiss()
            }
        }

        if (intent!=null)
            if(!intent.getStringExtra("webURL").isEmpty())
                web_View.loadUrl(intent.getStringExtra("webURL"))
    }

}
