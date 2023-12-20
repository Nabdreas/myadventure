package com.biggerthannull.myadventure.ui.composables.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.myadventure.domain.usecase.model.UpcomingEvent
import com.biggerthannull.myadventure.ui.composables.elements.ListDescription
import com.biggerthannull.myadventure.ui.composables.elements.ListExtraInfo
import com.biggerthannull.myadventure.ui.composables.elements.ListTitle
import com.biggerthannull.myadventure.ui.theme.MyAdventureTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryListItem(event: UpcomingEvent, navigate: (title: String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(4.dp)),
        onClick = {
            navigate(event.title)
        },
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            ListTitle(text = event.title)
            ListDescription(text = event.date)
            ListExtraInfo(text = event.location)
        }
    }
}

@Preview
@Composable
fun PrimaryListItemPreview() {
    MyAdventureTheme {
        PrimaryListItem(
            event = UpcomingEvent(
                title = "Bristol Audax",
                date = "21/01/2024",
                imageUrl = "https://theunknownaroundthecorner.files.wordpress" +
                        ".com/2020/09/20200927-10-edit.jpg?w=1000",
                location = "Bristol",
                distance = "150km",
                elevation = "2589m"
            ),
            navigate = {
                // No op
            }
        )
    }
}