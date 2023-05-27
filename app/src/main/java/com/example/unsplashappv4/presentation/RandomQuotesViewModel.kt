package com.example.unsplashappv4.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unsplashappv4.data.RandomQuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomQuotesViewModel @Inject constructor(
    private val repository: RandomQuotesRepository
): ViewModel() {

    private val _randomQuote = MutableStateFlow<UiStateTypeFit>(UiStateTypeFit.Loading)
    var randomQuote: StateFlow<UiStateTypeFit> = _randomQuote.asStateFlow()

    init {
        getRandomQuote()
    }

    private fun getRandomQuote(){
        viewModelScope.launch {
           val result =  repository.getRandomQuotes()
            _randomQuote.value = UiStateTypeFit.Success(quotes = result)
        }
    }
}