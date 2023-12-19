package com.biggerthannull.myadventure.ui.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.biggerthannull.myadventure.ui.theme.MyAdventureTheme

@Composable
fun DiscoverScreen() {
    Column(
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxSize()
    ) {
        Text(
            text = "Discover your local bicycle related businesses, cafes, shops and whatever else " +
                    "that can aid you along your adventures"
        )
    }
}

@Preview
@Composable
fun DiscoverScreenPreview() {
    MyAdventureTheme {
        DiscoverScreen()
    }
}