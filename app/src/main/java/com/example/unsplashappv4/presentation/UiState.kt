package com.example.unsplashappv4.presentation

import com.example.unsplashappv4.data.models.typefit.TypeFitQuotes
import com.example.unsplashappv4.data.models.unsplash.UnsplashApiPhotos

sealed class UiState {
    object Loading : UiState()
    data class Success(val data: UnsplashApiPhotos): UiState()
}

sealed class UiStateTypeFit {
    object Loading : UiStateTypeFit()
    data class Success(val quotes: TypeFitQuotes): UiStateTypeFit()
}