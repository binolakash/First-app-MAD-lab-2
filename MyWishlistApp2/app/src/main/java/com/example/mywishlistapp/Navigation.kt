package com.example.mywishlistapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(viewModel: WishViewModel= viewModel(),
               navController:NavController = rememberNavController()){
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ){

    }

}