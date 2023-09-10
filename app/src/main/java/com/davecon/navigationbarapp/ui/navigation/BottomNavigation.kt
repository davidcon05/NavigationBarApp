package com.davecon.navigationbarapp.ui.navigation

import androidx.compose.foundation.layout.RowScope
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
        icon = {
            Icon(imageVector = screen.selectedIcon, contentDescription = screen.contentDescription)
        },
        selected = currentRoute == screen.route,
        alwaysShowLabel = true,
        onClick = {
            if (currentRoute != screen.route) {
                navController.navigate(screen.route)
            }
        },
    )
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

/**
 * {
 *                             NavigationBar {
 *                                 items.forEachIndexed { index, item ->
 *                                     NavigationBarItem(
 *                                         selected = selectedItemIndex == index,
 *                                         onClick = {
 *                                             selectedItemIndex = index
 *                                             //navController.navigate(item.title)
 *                                         },
 *                                         label = {
 *                                             Text(text = item.title)
 *                                         },
 *                                         icon = {
 *                                             BadgedBox(
 *                                                 badge = {
 *                                                     if (item.badgeCount != null) {
 *                                                         Badge {
 *                                                             Text(text = item.badgeCount.toString())
 *                                                         }
 *                                                     } else if (item.hasNews) {
 *                                                         Badge()
 *                                                     }
 *                                                 }
 *                                             ) {
 *                                                 Icon(
 *                                                     imageVector = if (index == selectedItemIndex) {
 *                                                         item.selectedIcon
 *                                                     } else item.unselectedIcon,
 *                                                     contentDescription = item.title
 *                                                 )
 *                                             }
 *                                         }
 *                                     )
 *                                 }
 *                             }
 *                         }
 */