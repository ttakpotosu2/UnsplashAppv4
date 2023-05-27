package com.example.unsplashappv4.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.unsplashappv4.data.UnsplashApiPagingSource
import com.example.unsplashappv4.data.UnsplashRepo
import com.example.unsplashappv4.data.models.unsplash.UnsplashApiPhotos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class UnsplashPhotosViewModel @Inject constructor(
    private val repository: UnsplashRepo,
): ViewModel() {

    val photos: Flow<PagingData<UnsplashApiPhotos>> = Pager(
        PagingConfig(pageSize = 10)
    ) {
        UnsplashApiPagingSource(repository)
    }.flow.cachedIn(viewModelScope)
}