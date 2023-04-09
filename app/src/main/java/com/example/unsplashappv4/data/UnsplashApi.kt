package com.example.unsplashappv4.data

import com.example.unsplashappv4.BuildConfig
import com.example.unsplashappv4.data.models.UnsplashApiPhotos
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/photos")
    suspend fun getPhotos(
        @Query("page") page: Int,
    //  @Query("per_page") per_page: Int
    ): List<UnsplashApiPhotos>
}