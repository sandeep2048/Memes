package com.dillmill.sanson_memes.data.remote

import com.dillmill.sanson_memes.data.entities.CharacterList
import retrofit2.Response
import retrofit2.http.GET

interface CharacterService {
    @GET("get_memes")
    suspend fun getAllCharacters() : Response<CharacterList>
}