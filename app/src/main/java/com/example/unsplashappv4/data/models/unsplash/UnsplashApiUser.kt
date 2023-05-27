package com.example.unsplashappv4.data.models.unsplash

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class UnsplashApiUser (
    val name: String? = "No name",
    @SerializedName ("total_likes")
    val totalLikes: Int,
    val bio: String? = "No bio",
    val userName: String? = "No Username",
    val location: String?,
    @SerializedName("twitter_username")
    val twitterName: String? = "No name",
    @SerializedName("instagram_username")
    val instagramName: String? = "No name"

)