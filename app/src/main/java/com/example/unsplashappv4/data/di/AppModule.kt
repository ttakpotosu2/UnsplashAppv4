package com.example.unsplashappv4.data.di

//import com.example.unsplashappv4.data.TypeFitApi
import com.example.unsplashappv4.data.UnsplashApi
//import com.example.unsplashappv4.util.Constants.TYPE_FIT_BASE_URL
import com.example.unsplashappv4.util.Constants.UNSPLASH_BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .serializeNulls()
            .create()
    }

    @Provides
    @Singleton
    fun getLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun getOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun getRetrofitForUnsplash(
        gson: Gson,
        client: OkHttpClient
    ): UnsplashApi {

        return Retrofit.Builder()
            .baseUrl(UNSPLASH_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
            .create(UnsplashApi::class.java)
    }

//    @Provides
//    @Singleton
//    fun getRetrofitForTypeFit(
//        gson: Gson,
//        client: OkHttpClient
//    ): TypeFitApi {
//
//        return Retrofit.Builder()
//            .baseUrl(TYPE_FIT_BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .client(client)
//            .build()
//            .create(TypeFitApi::class.java)
//    }
}