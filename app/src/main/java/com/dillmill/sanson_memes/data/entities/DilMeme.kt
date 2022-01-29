package com.dillmill.sanson_memes.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memes")
data class DilMeme(
    val box_count: Int,
    val height: Int,
    val width: Int,
    @PrimaryKey
    val id: Int,
    val name: String,
    val url: String
)