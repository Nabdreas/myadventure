package com.biggerthannull.myadventure.ui.composables.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.myadventure.domain.usecase.model.UpcomingEvent
import com.biggerthannull.myadventure.ui.theme.MyAdventureTheme

@Composable
fun PrimaryListComponent(upcomingEvents: List<UpcomingEvent>, navigate: (title: String) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(items = upcomingEvents, itemContent = { event ->
            PrimaryListItem(event = event, navigate = navigate)
        })
    }
}


@Preview
@Composable
fun PrimaryListComponentPreview() {
    MyAdventureTheme {
        PrimaryListComponent(
            upcomingEvents = emptyList(),
            navigate = {
                // No op
            }
        )
    }
}