package com.davecon.navigationbarapp.ui.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(
    navController: NavHostController,
    items: List<BottomNavItem>
) {

    NavigationBar {
        items.forEach { item ->
            AddItem(screen = item, navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
    navController: NavHostController
) {
    val currentRoute = currentRoute(navController)
    NavigationBarItem(
        label = {
            Text(stringResource(id = screen.title))
        },
        selected = currentRoute == screen.route,
        alwaysShowLabel = true,
        onClick = {
            if (currentRoute != screen.route) {
                navController.navigate(screen.route)
            }
        },
        icon = {
            BadgedBox(badge = {
                if (screen.badgeCount != null) {
                    Badge {
                        Text(text = screen.badgeCount.toString())
                    }
                } else if (screen.hasNews) {
                    Badge()
                }
            }
            ) {
                Icon(
                    imageVector = if (currentRoute == screen.route) {
                        screen.selectedIcon
                    } else screen.unselectedIcon,
                    contentDescription = screen.contentDescription
                )
            }
        }
    )
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}