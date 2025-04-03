package com.example.marvel.Data.remote.api

import marvel_private_api_key
import marvel_public_api_key
import md5
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val API_URL = "http://gateway.marvel.com/v1/public/"

interface RemoteServices {
    companion object{
        private  val PUBLIC_KEY = marvel_public_api_key
        private  val PRIVATE_KEY = marvel_private_api_key
        private const val ts = "1"
    }

    @GET("characters")
fun getCharacter(
@Query("ts") ts: String="1",
@Query("apiKey") apiKey: String=PUBLIC_KEY,
@Query("hash") hash: String="${Companion.ts}$PRIVATE_KEY$PUBLIC_KEY".md5(),
@Query("limli") limit: Int=10,
@Query("page") page:Int,
@Query("page_limit") page_limit:Int
): Call<apiResponse>
}