package com.dillmill.sanson_memes.data.entities


data class CharacterList(
    val success: Boolean,
    val data: Meme
)

data class Meme(
    val memes:List<DilMeme>
)