package com.biggerthannull.myadventure.domain.usecase.model

data class UpcomingEvent(
    val title: String,
    val date: String,
    val imageUrl: String,
    val location: String,
    val distance: Int,
    val elevation: Int
)
