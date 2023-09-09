package com.davecon.navigationbarapp.ui.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun BottomNavigation() {

}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem
) {
    NavigationBarItem(
        label = {
            Text(stringResource(id = screen.title))
        },
        icon = {
            Icon(imageVector = screen.selectedIcon, contentDescription = screen.contentDescription)
        },
        selected = true,
        alwaysShowLabel = true,
        onClick = { /*TODO*/ },
    )
}