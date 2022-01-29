package com.dillmill.sanson_memes.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dillmill.sanson_memes.data.entities.DilMeme

@Dao
interface MemesDao {

    @Query("SELECT * FROM memes")
    fun getAllCharacters() : LiveData<List<DilMeme>>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<DilMeme>)




}