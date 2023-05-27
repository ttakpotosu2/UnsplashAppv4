package com.example.unsplashappv4.data.di

import android.content.Context
import androidx.room.Room
import com.example.unsplashappv4.data.models.typefit.TypeFitDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): TypeFitDatabase {
        return Room.databaseBuilder(
            context,
            TypeFitDatabase::class.java,
            "type_fit_db"
        ).build()
    }
}