package com.example.unsplashappv4.data

import com.example.unsplashappv4.data.models.typefit.TypeFitDatabase
import com.example.unsplashappv4.data.models.typefit.TypeFitEntity
import com.example.unsplashappv4.data.models.typefit.TypeFitQuotes
import javax.inject.Inject

class RandomQuotesRepository @Inject constructor(
    private val typeFitApi: TypeFitApi,
    private val database: TypeFitDatabase
){
    suspend fun getRandomQuotes(): TypeFitEntity {

        val quotes = typeFitApi.getQuotes().map { it.toTypeFitEntity() }
        database.typeFitDao().addAll(quotes)
        return database.typeFitDao().getAll().random()
    }
}