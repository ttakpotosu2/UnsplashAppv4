package com.example.unsplashappv4.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
// import com.example.unsplashappv4.data.RandomQuotesRepository
import com.example.unsplashappv4.data.models.typefit.TypeFitQuotes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
//class RandomQuotesViewModel @Inject constructor(
//    private val repository: RandomQuotesRepository
//): ViewModel() {
//
////    private val _randomQuote = MutableStateFlow<UiStateTypeFit>(UiStateTypeFit.Loading)
////    var randomQuote: StateFlow<UiStateTypeFit> = _randomQuote.asStateFlow()
//
//    init {
//        getRandomQuote()
//    }
//
//    private fun getRandomQuote(){
//        viewModelScope.launch {
//            repository.getRandomQuotes()
//        }
//    }
//}