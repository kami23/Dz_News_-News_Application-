package com.example.tdm1_demo_dz_now

import android.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.tdm1_demo_dz_now.Adapter.ListNewsAdapter
import com.example.tdm1_demo_dz_now.Interface.NewsService
import com.example.tdm1_demo_dz_now.Model.WebSite
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_saved.*
import kotlinx.android.synthetic.main.fragment_news.*
import retrofit2.Call
import retrofit2.Response

class SavedActivity : AppCompatActivity() {

    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var mService: NewsService
    lateinit var adapter : ListNewsAdapter
    lateinit var dialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved)

        mService.sources.enqueue(object : retrofit2.Callback<WebSite> {
            override fun onFailure(call: Call<WebSite>, t: Throwable) {
                Toast.makeText(baseContext, "Failed", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<WebSite>, response: Response<WebSite>) {

                test.text=response.body()!!.toString()

                //recycler_view_news.setHasFixedSize(true)
                //layoutManager= LinearLayoutManager(baseContext)
                //recycler_view_news.layoutManager=layoutManager

                //adapter = ListNewsAdapter(baseContext, response.body()!!)
                //adapter.notifyDataSetChanged()
                //recycler_view_news.adapter = adapter
            }
        })
    }

    private fun writeTodataBase(){
    //    FirebaseDatabase database = FirebaseDataase.getInstance();
      //  DataBaseReference myRef=dataBase.getReferences("articles");
        //myref.setValue("hello","world");
    }


}
