package com.biggerthannull.myadventure.data.datasource

import com.biggerthannull.myadventure.data.datasource.model.UpcomingEventsResponseDTO

interface EventsDataSource {
    suspend fun getUpcomingEvents(): Result<List<UpcomingEventsResponseDTO>>
}