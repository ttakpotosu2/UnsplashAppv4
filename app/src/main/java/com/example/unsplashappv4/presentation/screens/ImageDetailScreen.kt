package com.example.unsplashappv4.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.unsplashappv4.presentation.UiState
import com.example.unsplashappv4.presentation.theme.IBMPlex
import com.example.unsplashappv4.presentation.theme.UnsplashPhotoViewModel

@Composable
fun ImageDetailScreen(
    viewModel: UnsplashPhotoViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val details = viewModel.photo.value
    val scroll = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121010))
            .padding(16.dp)
            .verticalScroll(scroll),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        IconButton(
            onClick = { navHostController.navigateUp() },
            modifier = Modifier.size(40.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.White
            )
        }
        when (details) {
            is UiState.Success -> {
                val imagePainter = rememberAsyncImagePainter(
                    model = details.data.urls.regular
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = imagePainter,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.aspectRatio(1f, matchHeightConstraintsFirst = true)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Black.copy(0.5f))
                            .padding(10.dp)
                            .align(Alignment.BottomCenter),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = null,
                            tint = Color.Red
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = details.data.user.totalLikes.toString(),
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 20.sp
                            ),
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
                Text(
                    text = "user:: ${details.data.user.name}",
                    fontFamily = IBMPlex,
                    color = Color.White,
                    fontSize = 20.sp
                )

                Text(
                    text = "username:: ${details.data.user.userName}",
                    fontFamily = IBMPlex,
                    color = Color.White,
                    fontSize = 20.sp
                )
                Text(
                    text = "twitter:: ${details.data.user.twitterName}",
                    fontFamily = IBMPlex,
                    color = Color.White,
                    fontSize = 20.sp
                )
                Text(
                    text = "twitter:: ${details.data.user.instagramName}",
                    fontFamily = IBMPlex,
                    color = Color.White,
                    fontSize = 20.sp
                )
                Text(
                    text = "location:: ${details.data.user.location}",
                    fontFamily = IBMPlex,
                    color = Color.White,
                    fontSize = 20.sp
                )
                Text(
                    text = "bio:: ${details.data.user.bio}",
                    fontFamily = IBMPlex,
                    color = Color.White,
                    fontSize = 20.sp
                )
//                if(details.data.user.name != "null"){
//
//                }
//                if(details.data.user.userName != "null"){
//
//                }
//                if(details.data.user.twitterName != "null"){
//
//                }
//                if(details.data.user.instagramName != "null"){
//
//                }
//                if(details.data.user.location != "null"){
//
//                }
//                if(details.data.user.bio != "null"){
//
//                }
            }

            is UiState.Loading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(100.dp),
                        color = Color.White
                    )
                }
            }
        }
    }
}