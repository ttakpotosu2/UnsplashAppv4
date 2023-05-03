package com.example.unsplashappv4.data

import com.example.unsplashappv4.data.models.typefit.TypeFitQuotes
import javax.inject.Inject

class RandomQuotesRepository @Inject constructor(
    private val typeFitApi: TypeFitApi
){
    suspend fun getRandomQuotes(): TypeFitQuotes {
        return typeFitApi.getQuotes().random()
    }
}