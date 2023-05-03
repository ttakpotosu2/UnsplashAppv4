package com.example.unsplashappv4.data

import com.example.unsplashappv4.data.models.typefit.TypeFitQuotes
import retrofit2.http.GET

interface TypeFitApi {

    @GET("quotes")
    suspend fun getQuotes(): List<TypeFitQuotes>
}