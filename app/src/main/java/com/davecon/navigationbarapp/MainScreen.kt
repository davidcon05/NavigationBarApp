package com.davecon.navigationbarapp

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.davecon.navigationbarapp.ui.navigation.BottomNavItem
import com.davecon.navigationbarapp.ui.navigation.BottomNavigation

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Emails,
        BottomNavItem.Settings
    )

    Scaffold(
        bottomBar = {
            BottomNavigation(navController, items)
        }
    ) { innerPadding ->
        val padding = innerPadding
        MainScreenNavigationConfigurations(navController)
    }
}

@Composable
fun MainScreenNavigationConfigurations(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            ScaryScreen(scaryAnimation = BottomNavItem.Home, modifier = Modifier)
        }
        composable(BottomNavItem.Emails.route) {
            ScaryScreen(scaryAnimation = BottomNavItem.Emails, modifier = Modifier)
        }
        composable(BottomNavItem.Settings.route) {
            ScaryScreen(scaryAnimation = BottomNavItem.Settings, modifier = Modifier)
        }
    }
}