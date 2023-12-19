package com.biggerthannull.myadventure.ui.composables.elements

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.biggerthannull.myadventure.ui.theme.MyAdventureTheme

@Composable
fun ListTitle(text: String) {
    Text(text = text)
}

@Composable
fun ListDescription(text: String) {
    Text(text = text)
}

@Composable
fun ListExtraInfo(text: String) {
    Text(text = text)
}





@Preview
@Composable
fun ListTitlePreview() {
    MyAdventureTheme {
        ListTitle("I am title")
    }
}

@Preview
@Composable
fun ListDescriptionPreview() {
    MyAdventureTheme {
        ListDescription("I am description")
    }
}

@Preview
@Composable
fun ListExtraInfoPreview() {
    MyAdventureTheme {
        ListExtraInfo("I am extra info")
    }
}