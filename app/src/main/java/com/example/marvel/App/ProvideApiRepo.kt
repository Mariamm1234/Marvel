package com.example.marvel.App

import com.example.marvel.Data.remote.repository.apiRepo
import com.example.marvel.Data.remote.repository.apiRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProvideApiRepo {
    @Binds
   abstract fun provideRep(repo: apiRepoImpl):apiRepo
}