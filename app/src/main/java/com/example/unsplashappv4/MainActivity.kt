package com.example.unsplashappv4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.unsplashappv4.presentation.navigation.SetupNavGraph
import com.example.unsplashappv4.presentation.theme.UnsplashAppv4Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnsplashAppv4Theme {
                val navController = rememberNavController()
                SetupNavGraph(navHostController = navController)
            }
        }
    }
}