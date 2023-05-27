package com.example.unsplashappv4.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.unsplashappv4.R
import com.example.unsplashappv4.data.models.unsplash.UnsplashApiUrl
import com.example.unsplashappv4.presentation.*
import com.example.unsplashappv4.presentation.navigation.Screen
import com.example.unsplashappv4.presentation.theme.IBMPlex

@Composable
fun WelcomePage(
    navHostController: NavHostController,
    randomImageViewModel: RandomImageViewModel = hiltViewModel(),
    randomQuotesViewModel: RandomQuotesViewModel = hiltViewModel()
) {
    val randomPhoto = randomImageViewModel.randomPhoto.collectAsState()
    val quotes = randomQuotesViewModel.randomQuote.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff121010))
    ) {
        Text(
            text = "project_001",
            fontFamily = IBMPlex,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(24.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        when (quotes.value) {
            is UiStateTypeFit.Success -> {
                Text(
                    text = (quotes.value as UiStateTypeFit.Success).quotes.text,
                    fontFamily = IBMPlex,
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(24.dp)
                )
                (quotes.value as UiStateTypeFit.Success).quotes.author?.let {
                    Text(
                        text = it,
                        fontFamily = IBMPlex,
                        color = Color.White,
                        fontSize = 30.sp,
                        modifier = Modifier.padding(24.dp)
                    )
                }
            }

            is UiStateTypeFit.Loading -> {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(100.dp),
                        color = Color.White
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = {
                    navHostController.navigate(
                        Screen.HomeScreen.route
                    )
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        when (randomPhoto.value) {
            is UiState.Loading -> {
                AnimatedShimmer()
            }

            is UiState.Success -> {
                SingleImageCard(
                    imageUrl = (randomPhoto.value as UiState.Success).data.urls
                )
            }
        }
    }
}

@Composable
fun SingleImageCard(
    imageUrl: UnsplashApiUrl
) {
    val imagePainter = rememberAsyncImagePainter(
        model = imageUrl.regular,
        error = painterResource(id = R.drawable.ic_launcher_foreground),
    )
    Box(
        modifier = Modifier
            .height(300.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter,
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = imagePainter,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}