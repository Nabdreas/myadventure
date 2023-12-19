package com.biggerthannull.myadventure.domain.repository

import com.biggerthannull.myadventure.domain.usecase.model.UpcomingEventsResult

interface EventsRepository {
    fun getUpcomingEvents(): UpcomingEventsResult
}