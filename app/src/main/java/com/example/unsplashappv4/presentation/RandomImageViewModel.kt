package com.example.unsplashappv4.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unsplashappv4.data.RandomImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomImageViewModel @Inject constructor(
    private val repository: RandomImageRepository
): ViewModel() {

    private val _randomPhoto = MutableStateFlow<UiState>(UiState.Loading)
    var randomPhoto: StateFlow<UiState> = _randomPhoto.asStateFlow()

    init {
        getRandomPhoto()
    }

    private fun getRandomPhoto(){
        viewModelScope.launch {
            val result = repository.getRandomImage()
            _randomPhoto.value = UiState.Success(data = result)
        }
    }
}