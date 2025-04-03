package com.example.marvel.Data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.marvel.Data.local.entities.charactersEntity
import com.example.marvel.Data.local.entities.comicsEntity

data class characterHasMComics (
    @Embedded
    val character: charactersEntity,
    @Relation(parentColumn = "id",
        entityColumn = "id")
    val comics:List<comicsEntity>
)