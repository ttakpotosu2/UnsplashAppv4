package com.example.unsplashappv4.data.models.unsplash

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class UnsplashApiUser (
    val name: String,
    @SerializedName ("total_likes") val totalLikes: Int,
    val bio: String,
    val userName: String,
    val location: String,
    @SerializedName("twitter_username") val twitterName: String,
    @SerializedName("instagram_username") val instagramName: String

)