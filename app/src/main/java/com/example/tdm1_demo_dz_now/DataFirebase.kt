package com.example.tdm1_demo_dz_now

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

abstract class DataFirebase{

    companion object {
        private var database: DatabaseReference?=null
        private var userId:String?=null
        fun getInstance() : DatabaseReference?{
            if(database==null){
                database = FirebaseDatabase.getInstance().reference
            }
            return database
        }
        fun getUserId():String?{
            if(userId==null){
                userId = FirebaseAuth.getInstance().currentUser!!.uid
            }
            return userId
        }
    }



}