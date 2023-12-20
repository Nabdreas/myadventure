package com.biggerthannull.myadventure.ui.composables.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.biggerthannull.myadventure.ui.navigation.BottomNavItems
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.biggerthannull.myadventure.ui.theme.MyAdventureTheme
import com.biggerthannull.myadventure.ui.theme.balanceGreen

@Composable
fun BottomBarNavigationComponent(navController: NavHostController) {
    val barItems = listOf(
        BottomNavItems.Home, BottomNavItems.Discover, BottomNavItems.Profile
    )

    BottomNavigation(
        backgroundColor = balanceGreen,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        barItems.forEach { bottomItem ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = bottomItem.icon,
                        contentDescription = bottomItem.title,
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(
                        text = bottomItem.title, color = Color.Black, style = TextStyle(
                            fontWeight = FontWeight.Bold, fontSize = 12.sp
                        )
                    )
                },
                alwaysShowLabel = false,
                selected = currentRoute == bottomItem.route,
                selectedContentColor = Color.White,
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