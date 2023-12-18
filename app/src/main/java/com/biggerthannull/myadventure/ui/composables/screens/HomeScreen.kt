package com.biggerthannull.myadventure.ui.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.biggerthannull.myadventure.ui.theme.MyAdventureTheme
import com.biggerthannull.myadventure.ui.theme.balancedBeige
import com.biggerthannull.myadventure.ui.viewmodel.events.HomeScreenUserEvents
import com.biggerthannull.myadventure.ui.viewmodel.model.HomeUIState

@Composable
fun HomeScreen(uiState: HomeUIState, events: HomeScreenUserEvents) {
    Column(
        modifier = Modifier
            .background(balancedBeige)
            .fillMaxSize()
    ) {
        Text(
            text = uiState.title
        )
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    MyAdventureTheme {
        HomeScreen(
            uiState = HomeUIState(
                title = "Adventure"
            ),
            events = object : HomeScreenUserEvents {
                override fun selectEvent() {
                    // No op
                }

            }
        )
    }
}