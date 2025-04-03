package com.example.marvel.Data.local.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.marvel.Data.local.Dao.MarvelDao
import com.example.marvel.Data.local.entities.charactersEntity
import com.example.marvel.Data.local.entities.comicsEntity

@Database(entities = [charactersEntity::class,
    comicsEntity::class
], version = 1)
abstract class AppDatabase: RoomDatabase() {




    abstract fun provideMarvelDao(): MarvelDao

    companion object {
        val appDatabaseName = "Marvel.db"

        @Volatile
        private var instance: AppDatabase? = null
        val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?:buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context, AppDatabase::class.java,
            appDatabaseName
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}