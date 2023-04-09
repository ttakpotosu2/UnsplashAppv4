package com.example.unsplashappv4.data.models

import kotlinx.serialization.Serializable

@Serializable
data class UnsplashApiPhotos(
    val urls: UnsplashApiUrl,
    val user: UnsplashApiUser
)