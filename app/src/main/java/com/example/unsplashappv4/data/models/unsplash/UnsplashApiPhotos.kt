package com.example.unsplashappv4.data.models.unsplash

import kotlinx.serialization.Serializable

@Serializable
data class UnsplashApiPhotos(
    val id: String,
    val urls: UnsplashApiUrl,
    val user: UnsplashApiUser
)