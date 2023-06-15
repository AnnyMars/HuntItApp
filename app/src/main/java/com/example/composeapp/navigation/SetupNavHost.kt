package com.example.composeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeapp.MainViewModel
import com.example.composeapp.screens.MainScreen
import com.example.composeapp.screens.SplashScreen
import com.example.composeapp.screens.WebScreen
import com.example.composeapp.utils.Constants

sealed class Screens(val route: String){
    object Splash: Screens(route = Constants.Screens.SPLASH_SCREEN)
    object Main: Screens(route = Constants.Screens.MAIN_SCREEN)
    object Web: Screens(route = Constants.Screens.WEB_SCREEN)
}


@Composable
fun SetupNavHost(navController: NavHostController, viewModel: MainViewModel){
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ){
        composable(route = Screens.Splash.route){
            SplashScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.Main.route){
            MainScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.Web.route){
            WebScreen()
        }
    }
}