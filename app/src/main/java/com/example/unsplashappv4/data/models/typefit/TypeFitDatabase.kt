package com.example.unsplashappv4.data.models.typefit

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TypeFitEntity::class], version = 1, exportSchema = false)
abstract class TypeFitDatabase: RoomDatabase() {

    abstract fun typeFitDao(): TypeFitDao
}