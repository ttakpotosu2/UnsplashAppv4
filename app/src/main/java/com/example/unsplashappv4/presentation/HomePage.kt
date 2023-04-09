package com.example.unsplashappv4.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberAsyncImagePainter
import com.example.unsplashappv4.R
import com.example.unsplashappv4.data.UnsplashPhotosViewModel
import com.example.unsplashappv4.data.models.UnsplashApiUrl
import com.example.unsplashappv4.data.models.UnsplashApiUser

@Composable
fun HomeScreen(
    homeScreenViewModel: UnsplashPhotosViewModel = viewModel()
) {
    val unsplashList = homeScreenViewModel.photos.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(unsplashList) { images ->
            if (images != null) {
                ImageCard(
                    imageUrl = images.urls,
                    imageUser = images.user
                )
            }
        }

        unsplashList.apply {
            when{
                loadState.refresh is LoadState.Loading -> {
                    item {
                        AnimatedShimmer()
                    }
                }
                loadState.append is LoadState.Loading -> {
                    item { LoadingItem() }
                }
                loadState.refresh is LoadState.Error -> {
                    val e = unsplashList.loadState.refresh as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage!!,
                            modifier = Modifier.fillParentMaxSize(),
                            onClickRetry = {retry()}
                        )
                    }
                }
                loadState.append is LoadState.Error -> {
                //    val e = unsplashList.loadState.refresh as LoadState.NotLoading
                    item {
                        ErrorItem(
                            message = "Something went wrong.",
                            onClickRetry = {retry()}
                        )
                    }
                }
            }
        }
    }
}

// ORIGINAL
//        is UiState.Success -> {
//            LazyColumn(
//                modifier = Modifier.padding(16.dp),
//                verticalArrangement = Arrangement.spacedBy(16.dp)
//            ) {
//                items(uiState.data){
//                    ImageCard(imageUrl = it.urls, imageUser = it.user)
//                }
//            }
//        }


@Composable
fun ImageCard(
    imageUrl: UnsplashApiUrl,
    imageUser: UnsplashApiUser,
) {

    val imagePainter = rememberAsyncImagePainter(
        model = imageUrl.regular,
        error = painterResource(id = R.drawable.ic_launcher_foreground)
    )
    val userName = imageUser.name
    val userLikes = imageUser.totalLikes
    
    Box(modifier = Modifier
        .clickable { }
        .height(300.dp)
        .fillMaxWidth()
    ){
        Image(
            painter = imagePainter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black.copy(0.5f))
                .padding(10.dp)
                .align(Alignment.BottomCenter),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = userName,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                tint = Color.Red
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = userLikes.toString(),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}