package com.example.tdm1_demo_dz_now.Common

import com.example.tdm1_demo_dz_now.Interface.NewsService
import com.example.tdm1_demo_dz_now.Remote.RetrofitClient

object Common{
    val BASE_URL="https://newsapi.org/"
    val API_KEY ="7ed4f80d1228431ba67cfc1f75855ce6"


    val newsService:NewsService
    get()=RetrofitClient.getClient(BASE_URL).create(NewsService::class.java)

}