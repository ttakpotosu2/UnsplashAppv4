package com.example.unsplashappv4.data

import com.example.unsplashappv4.data.models.unsplash.UnsplashApiPhotos
import javax.inject.Inject

class RandomImageRepository @Inject constructor(
    private val unsplashApi: UnsplashApi
) {

    suspend fun getRandomImage(): UnsplashApiPhotos {
        return unsplashApi.getRandomImage(query = "stars")
    }
}