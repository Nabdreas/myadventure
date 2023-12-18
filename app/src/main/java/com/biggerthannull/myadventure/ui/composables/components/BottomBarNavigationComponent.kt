package com.biggerthannull.myadventure.ui.composables.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.biggerthannull.myadventure.ui.navigation.BottomNavItems
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.biggerthannull.myadventure.ui.theme.MyAdventureTheme
import com.biggerthannull.myadventure.ui.theme.Purple40

@Composable
fun BottomBarNavigationComponent(navController: NavHostController) {
    val barItems = listOf(
        BottomNavItems.Home, BottomNavItems.Discover, BottomNavItems.Profile
    )

    BottomNavigation(
        backgroundColor = Color.Gray
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        barItems.forEach { bottomItem ->
            BottomNavigationItem(icon = {
                // empty
            },
                label = {
                    Text(
                        text = bottomItem.title, color = Color.Black, style = TextStyle(
                            fontWeight = FontWeight.Bold, fontSize = 12.sp
                        )
                    )
                },
                selected = currentRoute == bottomItem.route,
                selectedContentColor = Purple40,
                onClick = {
                    navController.navigate(bottomItem.route) {
                        navController.graph.startDestinationRoute?.let { startDestination ->
                            popUpTo(startDestination)
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}

@Preview
@Composable
fun BottomBarNavigationComponentPreview() {
    MyAdventureTheme {
        BottomBarNavigationComponent(rememberNavController())
    }
}