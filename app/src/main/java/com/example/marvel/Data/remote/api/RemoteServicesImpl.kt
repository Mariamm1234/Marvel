package com.example.marvel.Data.remote.api

import android.annotation.SuppressLint
import android.util.Log
import com.example.marvel.Data.remote.Dto.MarvelCharacter
import com.example.marvel.constants.Source
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


//@SuppressLint("StaticFieldLeak")
object RemoteServicesImpl{
    val API= Source
    lateinit var  result: MutableList<MarvelCharacter>
  suspend fun getCharacters(page:Int,pageCount:Int) : MutableList<MarvelCharacter>
  {
          API.getClient().getCharacter(page = page, page_limit = pageCount).enqueue(object : Callback<apiResponse>{
              @SuppressLint("SuspiciousIndentation")
              override fun onResponse(
                  p0: Call<apiResponse>,
                  res: Response<apiResponse>
              ) {
                  if(res.body()?.code ==200)
                  result= res.body()?.data!!.results as MutableList<MarvelCharacter>
              }

              override fun onFailure(
                  p0: Call<apiResponse>,
                  p1: Throwable
              ) {
                 Log.i("failuer","api failed")
              }
          } )
      return result
  }
}