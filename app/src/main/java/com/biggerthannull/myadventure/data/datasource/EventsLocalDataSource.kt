package com.biggerthannull.myadventure.data.datasource

import com.biggerthannull.myadventure.data.datasource.model.UpcomingEventsDTO

interface EventsLocalDataSource {
    fun getUpcomingEvents(): Result<UpcomingEventsDTO>
}