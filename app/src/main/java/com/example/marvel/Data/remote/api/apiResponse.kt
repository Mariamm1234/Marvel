package com.example.marvel.Data.remote.api

import com.example.marvel.Data.remote.Dto.CharacterData

data class apiResponse(
    val code: Int,
    val status: String,
    val data: CharacterData
)
