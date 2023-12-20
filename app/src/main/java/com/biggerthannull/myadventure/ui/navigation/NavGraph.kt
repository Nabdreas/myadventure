package com.biggerthannull.myadventure.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.biggerthannull.myadventure.ui.composables.screens.DiscoverScreen
import com.biggerthannull.myadventure.ui.composables.screens.EventDetailsScreen
import com.biggerthannull.myadventure.ui.composables.screens.HomeScreen
import com.biggerthannull.myadventure.ui.composables.screens.ProfileScreen
import com.biggerthannull.myadventure.ui.viewmodel.HomeViewModel
import com.biggerthannull.myadventure.ui.viewmodel.events.HomeScreenUserEvents

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = NavigationRoutes.HOME) {
        composable(NavigationRoutes.HOME) {
            val viewModel: HomeViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsState()
            val event = viewModel as HomeScreenUserEvents
            HomeScreen(uiState, event) {
                navHostController.navigate(NavigationRoutes.EVENT_DETAILS)
            }
        }

        composable(NavigationRoutes.DISCOVER) {
            DiscoverScreen()
        }

        composable(NavigationRoutes.PROFILE) {
            ProfileScreen()
        }
        composable(NavigationRoutes.EVENT_DETAILS) {
            EventDetailsScreen()
        }
    }
}