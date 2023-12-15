package com.biggerthannull.myadventure.ui.composables.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.biggerthannull.myadventure.ui.theme.MyAdventureTheme
import com.biggerthannull.myadventure.ui.viewmodel.model.HomeUIState

@Composable
fun HomeScreen(uiState: HomeUIState) {
    Text(
        text = uiState.title
    )
}


@Preview
@Composable
fun HomeScreenPreview() {
    MyAdventureTheme {
        HomeScreen(
            uiState = HomeUIState(
                title = "Adventure"
            )
        )
    }
}