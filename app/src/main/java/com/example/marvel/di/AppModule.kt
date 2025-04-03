package com.example.marvel.di
import com.example.marvel.App.MarvelApp
import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.marvel.Data.local.Dao.MarvelDao
import com.example.marvel.Data.remote.api.RemoteServices

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.example.marvel.Data.local.DB.AppDatabase

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideContext(app: Application) = app.applicationContext

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): MarvelApp {
        return app as MarvelApp
    }


    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://gateway.marvel.com/v1/public/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides

    fun provideApi(retrofit: Retrofit): RemoteServices {
        return retrofit.create(RemoteServices::class.java)
    }

    @Singleton
    @Provides

    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
        return okHttpClient.build()
    }

    @Singleton
    @Provides

    fun provideInterceptor(): HttpLoggingInterceptor{
        val httpLoggingInterceptor= HttpLoggingInterceptor()
        httpLoggingInterceptor.level= HttpLoggingInterceptor.Level.BODY
        return  httpLoggingInterceptor
    }

@Singleton
@Provides
fun provideMarvelDao(app:AppDatabase): MarvelDao{
    return app.provideMarvelDao()
}
@Singleton
@Provides
fun provideDatabase(@ApplicationContext app: Context):AppDatabase{
    return Room.databaseBuilder(
        app.applicationContext,
        AppDatabase::class.java,
        "Marvel.db"
    ).fallbackToDestructiveMigration()
        .build()
}

}