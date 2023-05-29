package com.example.unsplashappv4.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TypeFitEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val text: String?,
    val author: String?
)
