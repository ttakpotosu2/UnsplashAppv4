package com.example.unsplashappv4.data.models.typefit

import kotlinx.serialization.Serializable

@Serializable
data class TypeFitQuotes(
    val text: String,
    val author: String? = "No Author"
)