package com.biggerthannull.myadventure.data.datasource

import com.biggerthannull.myadventure.data.datasource.model.UpcomingEventsResponseDTO

interface EventsLocalDataSource {
    fun getUpcomingEvents(): Result<UpcomingEventsResponseDTO>
}