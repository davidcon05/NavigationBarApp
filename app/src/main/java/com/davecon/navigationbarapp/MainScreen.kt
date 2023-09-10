package com.davecon.navigationbarapp

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.davecon.navigationbarapp.ui.navigation.BottomNavItem
import com.davecon.navigationbarapp.ui.navigation.BottomNavigation

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Emails,
        BottomNavItem.Settings
    )

    Scaffold(
        bottomBar = {
            BottomNavigation(navController, items)
        }
    ) {
        //MainScreenNavigationConfigurations(navController)
    }

}