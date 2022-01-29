package com.dillmill.sanson_memes.ui.characters

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dillmill.sanson_memes.data.entities.DilMeme
import com.dillmill.sanson_memes.data.entities.Meme
import com.dillmill.sanson_memes.data.repository.DilMemeRepository
import com.dillmill.sanson_memes.utils.Resource

class MemesViewModel @ViewModelInject constructor(
    private val repository: DilMemeRepository
) : ViewModel() {


    var charact = repository.getCharacters()


}
