package com.example.marvel.Data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class comicsEntity (
    @PrimaryKey
    val id:Int,
    val digitalId:Int,
    val name:String,
    val image:String?,
    val modified:String
)