package com.example.tdm1_demo_dz_now.Interface
import com.example.tdm1_demo_dz_now.Model.WebSite
import retrofit2.Call
import retrofit2.http.GET

interface NewsService {
    @get:GET("https://newsapi.org/v2/sources?apiKey=7ed4f80d1228431ba67cfc1f75855ce6")
    val sources: Call<WebSite>
}