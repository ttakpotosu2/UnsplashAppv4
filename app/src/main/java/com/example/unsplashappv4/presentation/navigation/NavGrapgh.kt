package com.example.unsplashappv4.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.unsplashappv4.presentation.screens.HomeScreen
import com.example.unsplashappv4.presentation.screens.ImageDetailScreen
import com.example.unsplashappv4.presentation.screens.WelcomePage

@Composable
fun SetupNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.WelcomePage.route
    ){
        composable(route = Screen.WelcomePage.route){
            WelcomePage(navHostController)
        }
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navHostController)
        }
        composable(route = Screen.ImageDetailScreen.route + "/{imageDetails}"){
            ImageDetailScreen()
        }
    }
}