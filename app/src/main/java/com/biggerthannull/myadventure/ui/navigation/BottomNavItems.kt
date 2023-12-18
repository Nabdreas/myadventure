package com.biggerthannull.myadventure.ui.navigation


sealed class BottomNavItems(val title: String, val route: String) {
    object Home: BottomNavItems("Home",  NavigationRoutes.HOME)
    object Discover: BottomNavItems("Discover",  NavigationRoutes.DISCOVER)
    object Profile: BottomNavItems("Profile", NavigationRoutes.Profile)
}
