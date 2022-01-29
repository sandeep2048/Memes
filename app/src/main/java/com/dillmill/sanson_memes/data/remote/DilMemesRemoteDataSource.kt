package com.dillmill.sanson_memes.data.remote

import javax.inject.Inject

class DilMemesRemoteDataSource @Inject constructor(
    private val characterService: CharacterService
): BaseDataSource() {

    suspend fun getCharacters() = getResult { characterService.getAllCharacters() }
}