package com.example.unsplashappv4.presentation.navigation

sealed class Screen(val route: String){
    object WelcomePage: Screen("welcome_page")
    object HomeScreen: Screen("home_page")
    object ImageDetailScreen: Screen("image_detail_screen")
}
