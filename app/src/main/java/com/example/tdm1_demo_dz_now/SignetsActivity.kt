package com.example.tdm1_demo_dz_now

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tdm1_demo_dz_now.Adapter.ListSavedAdapter
import com.example.tdm1_demo_dz_now.Data.ArticleEntity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_saved.*

class SignetsActivity : AppCompatActivity() {
    private lateinit var layoutManager: androidx.recyclerview.widget.LinearLayoutManager
    private var savedArticles : ArrayList<ArticleEntity> = ArrayList()
    private lateinit var database: DatabaseReference
    private lateinit var userId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signets)

        database=DataFirebase.getInstance()!!
        userId=DataFirebase.getUserId()!!

        val listener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val reminders: List<String> = dataSnapshot.children.mapNotNull { it.getValue<ArticleEntity>(ArticleEntity::class.java)!!.link }
                Log.i("kami", reminders.joinToString())
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("kami", "listener:onCancelled", databaseError.toException())
            }
        }
        val remindersReference = database.child("articles").child(userId).child("urls")
        remindersReference.addValueEventListener(listener)

        /*recycler_saved.setHasFixedSize(true)
        layoutManager= androidx.recyclerview.widget.LinearLayoutManager(baseContext)
        recycler_saved.layoutManager=layoutManager

        var adapter = ListSavedAdapter(savedArticles,baseContext)
        adapter.notifyDataSetChanged()
        recycler_saved.adapter = adapter*/


    }
}
