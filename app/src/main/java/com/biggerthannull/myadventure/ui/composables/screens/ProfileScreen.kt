package com.biggerthannull.myadventure.ui.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.biggerthannull.myadventure.ui.theme.MyAdventureTheme
import com.biggerthannull.myadventure.ui.theme.hillsGreen

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .background(hillsGreen)
            .fillMaxSize()
    ) {
        Text(
            text = "Your profile"
        )
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    MyAdventureTheme {
        ProfileScreen()
    }
}