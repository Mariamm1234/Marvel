package com.example.marvel.Data.local.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.marvel.Data.remote.Dto.Url
@Entity
data class charactersEntity (
    @PrimaryKey(autoGenerate = false)
    var id:Int,
    var name: String,
    var description: String,
    var modified: String,
    @Ignore
    var image:String
)
{
    // Room needs a default constructor
    constructor() : this(0, "", "", "", "")
}