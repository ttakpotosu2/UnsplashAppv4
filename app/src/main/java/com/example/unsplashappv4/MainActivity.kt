package com.example.unsplashappv4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.unsplashappv4.presentation.HomeScreen
import com.example.unsplashappv4.presentation.theme.UnsplashAppv4Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnsplashAppv4Theme {
                HomeScreen()
            }
        }
    }
}