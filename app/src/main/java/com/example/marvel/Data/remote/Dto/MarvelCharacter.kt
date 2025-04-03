package com.example.marvel.Data.remote.Dto

import java.net.URL

data class MarvelCharacter(
val id:Int,
    val name: String,
    val description: String,
    val modified: String,
    val resourceURI: String,
    val urls: Url,
    val thumbnail:Image,
    val comics: List<Comics>,
    val stories:List<Stories>,
    val events: List<Events>,
    val series: List<Series>
)
