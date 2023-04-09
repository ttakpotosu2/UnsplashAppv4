package com.example.unsplashappv4.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class UnsplashApiUser (
    val name: String,
    @SerializedName ("total_likes") val totalLikes: Int
)