package com.biggerthannull.myadventure.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomNavItems(val title: String, val icon: ImageVector, val route: String) {
    object Home: BottomNavItems("Home",  Icons.Default.Home, NavigationRoutes.HOME)
    object Discover: BottomNavItems("Discover",  Icons.Default.Place, NavigationRoutes.DISCOVER)
    object Profile: BottomNavItems("Profile", Icons.Default.AccountCircle, NavigationRoutes.PROFILE)
}
