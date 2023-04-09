package com.example.unsplashappv4.presentation

import com.example.unsplashappv4.data.models.UnsplashApiPhotos

sealed class UiState {
    object Loading : UiState()
    data class Success(val data: List<UnsplashApiPhotos>): UiState()
}