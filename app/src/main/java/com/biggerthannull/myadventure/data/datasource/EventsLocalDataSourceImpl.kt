package com.biggerthannull.myadventure.data.datasource

import com.biggerthannull.myadventure.data.datasource.model.UpcomingEventsResponseDTO
import javax.inject.Inject

class EventsLocalDataSourceImpl @Inject constructor() : EventsLocalDataSource {
    override fun getUpcomingEvents(): Result<UpcomingEventsResponseDTO> {
        return Result.failure(Exception("Implement DB pleb")
        )
    }
}