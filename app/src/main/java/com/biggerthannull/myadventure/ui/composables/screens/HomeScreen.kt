package com.biggerthannull.myadventure.ui.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.biggerthannull.myadventure.R
import com.biggerthannull.myadventure.ui.composables.components.PrimaryListComponent
import com.biggerthannull.myadventure.ui.composables.components.SpinnerComponent
import com.biggerthannull.myadventure.ui.theme.MyAdventureTheme
import com.biggerthannull.myadventure.ui.theme.balancedBeige
import com.biggerthannull.myadventure.ui.viewmodel.events.HomeScreenUserEvents
import com.biggerthannull.myadventure.ui.viewmodel.model.HomeUIState

@Composable
fun HomeScreen(uiState: HomeUIState, events: HomeScreenUserEvents, navigate:(eventId: String) ->
Unit) {
    Column(
        modifier = Modifier
            .background(balancedBeige)
            .fillMaxSize()
    ) {
        when (uiState) {
            is HomeUIState.Loading -> SpinnerComponent()
            is HomeUIState.Error -> Text(text = stringResource(id = R.string.generic_data_error))
            is HomeUIState.Loaded -> {
                if (uiState.upcomingEvents.isNotEmpty()) {
                    PrimaryListComponent(upcomingEvents = uiState.upcomingEvents) {
                        navigate(it)
                    }
                } else {
                    Text(text = stringResource(id = R.string.no_upcoming_events))
                }
            }
        }

    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    MyAdventureTheme {
        HomeScreen(
            uiState = HomeUIState.Loaded(),
            events = object : HomeScreenUserEvents {
                override fun selectEvent(title: String) {
                    // No op
                }
            },
            navigate = {
                // no op
            }
        )
    }
}