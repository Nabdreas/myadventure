package com.biggerthannull.myadventure.data.repository

import com.biggerthannull.myadventure.data.datasource.EventsDataSource
import com.biggerthannull.myadventure.data.datasource.EventsLocalDataSource
import com.biggerthannull.myadventure.data.datasource.model.UpcomingEventsResponseDTO
import com.biggerthannull.myadventure.domain.repository.EventsRepository
import com.biggerthannull.myadventure.domain.usecase.model.UpcomingEvent
import com.biggerthannull.myadventure.domain.usecase.model.UpcomingEventsResult
import javax.inject.Inject

class EventsRepositoryImpl @Inject constructor(
    private val eventsLocalDataSource: EventsLocalDataSource,
    private val eventsDataSource: EventsDataSource
) : EventsRepository {
    override suspend fun getUpcomingEvents(): UpcomingEventsResult {
        return eventsDataSource.getUpcomingEvents().fold(
            onSuccess = { dto ->
                val result = dtoToDomain(dto)
                UpcomingEventsResult.Success(upcomingEvents = result)
            },
            onFailure = {
                UpcomingEventsResult.Failed
            }
        )
    }

    private fun dtoToDomain(dto: List<UpcomingEventsResponseDTO>): List<UpcomingEvent> {
        return dto.map { event ->
            UpcomingEvent(
                title = event.title.orEmpty(),
                date = event.date.toString(),
                imageUrl = event.imageUrl.orEmpty(),
                location = event.startingLocation.orEmpty(),
                distance = event.distance.orEmpty(),
                elevation = event.climb.orEmpty(),
            )
        }
    }
}