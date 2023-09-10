package com.davecon.navigationbarapp.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.davecon.navigationbarapp.R
import com.davecon.navigationbarapp.R.string.email
import com.davecon.navigationbarapp.R.string.home
import com.davecon.navigationbarapp.R.string.settings

sealed class BottomNavItem(
    val route: String,
    val title: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null,
    val contentDescription: String? = null,
    val lottieAnimationId: Int
) {
    object Home : BottomNavItem(
        route = "Frankendroid",
        title = home,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        hasNews = false,
        contentDescription = "Home Screen",
        lottieAnimationId = R.raw.pumpkinstein
    )

    object Emails : BottomNavItem(
        route = "Ghost",
        title = email,
        selectedIcon = Icons.Filled.Email,
        unselectedIcon = Icons.Outlined.Email,
        hasNews = false,
        badgeCount = 12,
        contentDescription = "Email Screen",
        lottieAnimationId = R.raw.ghost
    )

    object Settings : BottomNavItem(
        route = "Pumpkins",
        title = settings,
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        hasNews = true,
        contentDescription = "Settings Screen",
        lottieAnimationId = R.raw.three_pumpkins
    )
}
