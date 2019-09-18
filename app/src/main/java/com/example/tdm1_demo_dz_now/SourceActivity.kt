package com.example.tdm1_demo_dz_now

import android.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.tdm1_demo_dz_now.Adapter.ListSourceAdapter
import com.example.tdm1_demo_dz_now.Common.Common
import com.example.tdm1_demo_dz_now.Interface.NewsService
import com.example.tdm1_demo_dz_now.Model.WebSite
import com.google.gson.Gson
import dmax.dialog.SpotsDialog
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_source.*
import retrofit2.Call
import retrofit2.Response

class SourceActivity : AppCompatActivity() {

    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var mService:NewsService
    lateinit var adapter : ListSourceAdapter
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source)

        //init chache DB
        Paper.init(this)
        // Init Service
        mService = Common.newsService

        //Init view
       /* swipe_to_refresh.setOnRefreshListener {
            loadWebSiteSource(true)
        }*/
        recycler_view_source_news.setHasFixedSize(true)
        layoutManager= LinearLayoutManager(this)
        recycler_view_source_news.layoutManager=layoutManager
        dialog=SpotsDialog(this)
        fetchData()
        //loadWebSiteSource(false)
    }

    private fun loadWebSiteSource(isRefresh: Boolean) {
         if(!isRefresh){
             val cache=Paper.book().read<String>("cache")
             if(cache!= null && !cache.isBlank() && cache != "null")
             {
                 val webSite = Gson().fromJson<WebSite>(cache,WebSite::class.java)
                 println(webSite)
                 adapter = ListSourceAdapter(baseContext,webSite)
                 adapter.notifyDataSetChanged()
                 recycler_view_source_news.adapter=adapter
             }
             else
             {
                 dialog.show()
                 mService.sources.enqueue(object : retrofit2.Callback<WebSite> {
                     override fun onFailure(call: Call<WebSite>, t: Throwable) {
                        Toast.makeText(baseContext,"Failed",Toast.LENGTH_SHORT).show()
                      }

                     override fun onResponse(call: Call<WebSite>, response: Response<WebSite>) {
                        adapter=ListSourceAdapter(baseContext,response.body()!!)
                        adapter.notifyDataSetChanged()
                        recycler_view_source_news.adapter=adapter

                         //save to cache

                         Paper.book().write("cache",Gson().toJson(response.body()!!))
                         dialog.dismiss()
                     }

                 })
             }
         }
        else
         {
             swipe_to_refresh.isRefreshing=true

             //Fetch new Data
             mService.sources.enqueue(object : retrofit2.Callback<WebSite> {
                 override fun onFailure(call: Call<WebSite>, t: Throwable) {
                     Toast.makeText(baseContext,"Failed",Toast.LENGTH_SHORT).show()
                 }

                 override fun onResponse(call: Call<WebSite>, response: Response<WebSite>) {
                     adapter=ListSourceAdapter(baseContext,response.body()!!)
                     adapter.notifyDataSetChanged()
                     recycler_view_source_news.adapter=adapter

                     //save to cache

                     Paper.book().write("cache",Gson().toJson(response.body()!!))

                     swipe_to_refresh.isRefreshing=false
                 }


             })

         }
    }

    fun fetchData() {
        //Fetch new Data
        mService.sources.enqueue(object : retrofit2.Callback<WebSite> {
            override fun onFailure(call: Call<WebSite>, t: Throwable) {
                Toast.makeText(baseContext, "Failed", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<WebSite>, response: Response<WebSite>) {
                adapter = ListSourceAdapter(baseContext, response.body()!!)
                adapter.notifyDataSetChanged()
                recycler_view_source_news.adapter = adapter

            }
        })
    }

}
