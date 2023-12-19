package com.biggerthannull.myadventure.data.datasource.model

data class UpcomingEventsDTO(
    val data: EventDTO
)

data class EventDTO(
    val title: String,
    val date: String,
    val imageUrl: String,
    val location: String,
    val distance: Int,
    val elevation: Int
)
