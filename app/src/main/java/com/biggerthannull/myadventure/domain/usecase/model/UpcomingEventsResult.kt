package com.biggerthannull.myadventure.domain.usecase.model

sealed class UpcomingEventsResult {
    object Failed : UpcomingEventsResult()
    data class Success(val upcomingEvents: List<UpcomingEvent>) : UpcomingEventsResult()
}