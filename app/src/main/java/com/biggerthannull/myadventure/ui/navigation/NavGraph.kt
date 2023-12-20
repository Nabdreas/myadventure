package com.biggerthannull.myadventure.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.biggerthannull.myadventure.ui.composables.screens.DiscoverScreen
import com.biggerthannull.myadventure.ui.composables.screens.EventDetailsScreen
import com.biggerthannull.myadventure.ui.composables.screens.HomeScreen
import com.biggerthannull.myadventure.ui.composables.screens.ProfileScreen
import com.biggerthannull.myadventure.ui.viewmodel.EventDetailsViewModel
import com.biggerthannull.myadventure.ui.viewmodel.HomeViewModel
import com.biggerthannull.myadventure.ui.viewmodel.events.HomeScreenUserEvents

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = NavigationRoutes.HOME) {
        composable(NavigationRoutes.HOME) {
            val viewModel: HomeViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsState()
            val event = viewModel as HomeScreenUserEvents
            HomeScreen(uiState, event) { eventId ->
                navHostController.navigate("eventDetails/$eventId")
            }
        }

        composable(NavigationRoutes.DISCOVER) {
            DiscoverScreen()
        }

        composable(NavigationRoutes.PROFILE) {
            ProfileScreen()
        }
        composable(NavigationRoutes.EVENT_DETAILS,
            arguments = listOf(navArgument("event_id") {
                type = NavType.StringType
            })
        ) {
            val viewModel: EventDetailsViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsState()
            EventDetailsScreen(uiState)
        }
    }
}