package com.example.unsplashappv4.data

import com.example.unsplashappv4.data.models.unsplash.UnsplashApiPhotos
import javax.inject.Inject

class UnsplashRepo @Inject constructor(
    private val unsplashApi: UnsplashApi
) {
    suspend fun getPhotos(pageNumber: Int): List<UnsplashApiPhotos> {
        return unsplashApi.getPhotos(pageNumber)
    }

    suspend fun getPhoto(photoId: String): UnsplashApiPhotos{
        return unsplashApi.getPhoto(photoId)
    }
}