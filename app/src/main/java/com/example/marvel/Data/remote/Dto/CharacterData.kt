package com.example.marvel.Data.remote.Dto

data class CharacterData(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<MarvelCharacter>
)
