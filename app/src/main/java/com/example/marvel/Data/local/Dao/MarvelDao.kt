package com.example.marvel.Data.local.Dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvel.Data.local.entities.charactersEntity

@Dao
interface MarvelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addOne(char: charactersEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun addAll(character: List<charactersEntity>)

    @Query("SELECT*FROM charactersEntity")
    fun pagingSource(): PagingSource<Int, charactersEntity>

    @Query("DELETE FROM charactersEntity")
    fun clearAll()
}