package com.example.unsplashappv4.data.models.typefit

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TypeFitDao {
    @Query("SELECT * FROM typefitentity")
    suspend fun getAll(): List<TypeFitEntity>

    @Insert
    suspend fun addAll(quotes: List<TypeFitEntity>)

    @Delete
    suspend fun delete(quotes: TypeFitEntity)
}