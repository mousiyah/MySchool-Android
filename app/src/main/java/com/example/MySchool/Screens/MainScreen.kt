package com.example.MySchool.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.MySchool.Components.Menu
import com.example.MySchool.Components.makeMenuItems

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val menuItems = remember { makeMenuItems() }
    var selectedItemIndex by remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = menuItems[selectedItemIndex].route
        ) {
            menuItems.forEach { menuItem ->
                composable(menuItem.route) {
                    Content(menuItem.route)
                }
            }
        }

        Menu(
            items = menuItems,
            selectedItemIndex = selectedItemIndex,
            onSelected = { index ->
                selectedItemIndex = index
                navController.navigate(menuItems[index].route)
            },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun Content(route: String) {
    when (route) {
        Screens.Dashboard.route -> DashboardScreen()
        Screens.Timetable.route -> TimetableScreen()
        else -> Text("Not implemented")
    }
}