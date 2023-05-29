package com.example.unsplashappv4.data.models.typefit

import com.example.unsplashappv4.data.local.TypeFitEntity
import kotlinx.serialization.Serializable

@Serializable
data class TypeFitQuotes(
    val text: String,
    val author: String? = "No Author"
){
    fun toTypeFitEntity(): TypeFitEntity {
        return TypeFitEntity(
            id = 0,
            text = text,
            author = author
        )
    }
}