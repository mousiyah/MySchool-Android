package com.example.MySchool.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.MySchool.Screens.LoginScreen
import com.example.MySchool.Screens.MainScreen
import com.example.MySchool.Screens.Screens

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.Login.route) {
        composable(Screens.Login.route) {
            LoginScreen (onLoginSuccess = { navController.navigate(Screens.Main.route) })
        }
        composable((Screens.Main.route)) {
            MainScreen()
        }
    }
}
