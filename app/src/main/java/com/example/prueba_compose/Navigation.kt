package com.example.prueba_compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(){
    val navController = rememberNavController()
    
    NavHost(navController = navController , startDestination = "A"){

        composable(route = "A"){
            AScreen(navController)
        }
        composable(route = "B"){
            BScreen(navController)
        }
        composable(route = "C"){
            CScreen(navController)
        }
    }
}