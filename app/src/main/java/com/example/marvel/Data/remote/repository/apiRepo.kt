package com.example.marvel.Data.remote.repository

import com.example.marvel.Data.remote.Dto.MarvelCharacter

interface apiRepo {
    suspend fun getCharacters(page:Int,pageCount:Int): MutableList<MarvelCharacter>
}