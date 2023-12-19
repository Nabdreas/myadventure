package com.biggerthannull.myadventure.data.repository

import com.biggerthannull.myadventure.data.datasource.EventsLocalDataSource
import com.biggerthannull.myadventure.data.datasource.model.EventDTO
import com.biggerthannull.myadventure.domain.repository.EventsRepository
import com.biggerthannull.myadventure.domain.usecase.model.UpcomingEvent
import com.biggerthannull.myadventure.domain.usecase.model.UpcomingEventsResult
import javax.inject.Inject

class EventsRepositoryImpl @Inject constructor(
    private val eventsLocalDataSource: EventsLocalDataSource
) : EventsRepository {
    override fun getUpcomingEvents(): UpcomingEventsResult {
        return eventsLocalDataSource.getUpcomingEvents().fold(
            onSuccess = { dto ->
                val result = dtoToDomain(dto.data)
                val listOfUpcomingEvents = MutableList(10) {
                    result
                }
                UpcomingEventsResult.Success(upcomingEvents = listOfUpcomingEvents)
            },
            onFailure = {
                UpcomingEventsResult.Failed
            }
        )
    }

    private fun dtoToDomain(dto: EventDTO): UpcomingEvent {
        return UpcomingEvent(
            title = dto.title,
            date = dto.date,
            imageUrl = dto.imageUrl,
            location = dto.location,
            distance = dto.distance,
            elevation = dto.elevation
        )
    }
}