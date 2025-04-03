package com.example.marvel.constants

import com.example.marvel.Data.remote.api.RemoteServices
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Source {
    fun getClient(): RemoteServices
    {
        var retrofit: Retrofit?=null
        val gson= GsonBuilder()
            .setLenient().create()

        if(retrofit==null)
        {
            retrofit= Retrofit.Builder()
                .baseUrl("http://gateway.marvel.com/v1/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(RemoteServices::class.java)
    }
}