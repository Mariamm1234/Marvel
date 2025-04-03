package com.example.marvel.Data.remote.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.marvel.Data.local.DB.AppDatabase
import com.example.marvel.Data.local.entities.charactersEntity

import com.example.marvel.Data.remote.repository.apiRepo
import okio.IOException
import retrofit2.HttpException
import toCharactersEntity


@OptIn(ExperimentalPagingApi::class)
class MarvelRemoteMediator(
    private  val marvelDb: AppDatabase,
    private val marvelApi: apiRepo
) : RemoteMediator<Int, charactersEntity>(){
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, charactersEntity>
    ): MediatorResult {
        return try {
val loadKey=
    when(loadType){
    LoadType.REFRESH-> 1
        LoadType.PREPEND -> return MediatorResult.Success(
            endOfPaginationReached = true
        )
        LoadType.APPEND -> {
val lastItem=state.lastItemOrNull()
            if(lastItem==null)
                1
            else{
                (lastItem.id/state.config.pageSize)+1
            }
        }

}
            //call api
            val marvelCharacters=  marvelApi.getCharacters(
                page = loadKey,
                pageCount = state.config.pageSize
            )
 marvelDb.withTransaction{
     if (loadType == LoadType.REFRESH)
     {
         marvelDb.provideMarvelDao().clearAll()
     }
     val entity= marvelCharacters.map{it.toCharactersEntity()}
     marvelDb.provideMarvelDao().addAll(entity)

     MediatorResult.Success(
         endOfPaginationReached = marvelCharacters.isEmpty()
     )
 }

        } catch (e: IOException){
            MediatorResult.Error(e)
        } catch (e: HttpException){
            MediatorResult.Error(e)
        }
    }
}