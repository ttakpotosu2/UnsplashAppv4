package com.example.unsplashappv4.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.unsplashappv4.data.local.TypeFitEntity

@Dao
interface TypeFitDao {
    @Query("SELECT * FROM typefitentity")
    suspend fun getAll(): List<TypeFitEntity>

    @Insert
    suspend fun addAll(quotes: List<TypeFitEntity>)

    @Delete
    suspend fun delete(quotes: TypeFitEntity)
}