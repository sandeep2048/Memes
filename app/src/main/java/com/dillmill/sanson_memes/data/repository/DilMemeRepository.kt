package com.dillmill.sanson_memes.data.repository

import com.dillmill.sanson_memes.data.local.MemesDao
import com.dillmill.sanson_memes.data.remote.DilMemesRemoteDataSource
import com.dillmill.sanson_memes.utils.performGetOperation

import javax.inject.Inject

class DilMemeRepository @Inject constructor(
    private val remoteDataSource: DilMemesRemoteDataSource,
    private val localDataSource: MemesDao
) {

    fun getCharacters() = performGetOperation(
        databaseQuery = { localDataSource.getAllCharacters() },
        networkCall = { remoteDataSource.getCharacters()},
        saveCallResult = { localDataSource.insertAll(it.data.memes) }
    )
}