package com.example.unsplashappv4.data

import com.example.unsplashappv4.data.local.TypeFitDatabase
import com.example.unsplashappv4.data.local.TypeFitEntity
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