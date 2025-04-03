package com.example.marvel.Data.remote.repository

import com.example.marvel.Data.remote.api.RemoteServices
import com.example.marvel.Data.remote.api.RemoteServicesImpl
import com.example.marvel.Data.remote.Dto.MarvelCharacter
import javax.inject.Inject

class apiRepoImpl @Inject constructor(
   val remoteServices: RemoteServicesImpl
): apiRepo{
    override suspend fun getCharacters(page:Int,pageCount:Int): MutableList<MarvelCharacter> {
        return remoteServices.getCharacters(page=page,pageCount=pageCount)
    }

}