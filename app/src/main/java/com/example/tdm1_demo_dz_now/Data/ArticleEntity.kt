package com.example.tdm1_demo_dz_now.Data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tdm1_demo_dz_now.Model.Source
import java.io.Serializable

@Entity (tableName = "article_table")
data class ArticleEntity (
    @PrimaryKey @ColumnInfo val title: String,
    @ColumnInfo val content:String,
    @ColumnInfo val image_url:String,
    @ColumnInfo val date: String,
    @ColumnInfo val link:String,
    @ColumnInfo val description:String
// @Embedded(prefix = "source_") val source:Source
)
