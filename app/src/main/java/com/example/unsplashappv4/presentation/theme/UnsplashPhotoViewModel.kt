package com.example.unsplashappv4.presentation.theme

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unsplashappv4.data.UnsplashRepo
import com.example.unsplashappv4.presentation.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UnsplashPhotoViewModel @Inject constructor(
    private val repository: UnsplashRepo,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _photo = mutableStateOf<UiState>(UiState.Loading)
    val photo: State<UiState> = _photo

    init {
        savedStateHandle.get<String>("photoId")?.let { getPhoto(it) }
    }

    private fun getPhoto(id: String){
        viewModelScope.launch {
            val result = repository.getPhoto(id)
            _photo.value = UiState.Success(data = result)
        }
    }
}