package com.example.unsplashappv4.data.models.typefit

import kotlinx.serialization.Serializable

@Serializable
data class TypeFitQuotes(
    val text: String,
    val author: String? = "No Author"
){
    fun toTypeFitEntity(): TypeFitEntity{
        return TypeFitEntity(
            id = 0, // TODO: Winging it here. lets find out later what to do with this id thingy
            text = text,
            author = author
        )
    }
}