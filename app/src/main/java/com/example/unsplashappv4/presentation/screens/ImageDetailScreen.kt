package com.example.unsplashappv4.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberAsyncImagePainter
import com.example.unsplashappv4.presentation.UnsplashPhotosViewModel
import kotlinx.coroutines.flow.collect

@Composable
fun ImageDetailScreen(
    homeScreenViewModel: UnsplashPhotosViewModel = hiltViewModel()
) {
    val imageDetails = homeScreenViewModel.photos.collectAsLazyPagingItems()

    val imagePainter = rememberAsyncImagePainter(
        model = imageDetails
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121010))
            .padding(16.dp)
    ) {

    }
}