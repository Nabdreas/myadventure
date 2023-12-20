package com.biggerthannull.myadventure.domain.usecase

import com.biggerthannull.myadventure.domain.repository.EventsRepository
import com.biggerthannull.myadventure.domain.usecase.model.UpcomingEventsResult
import javax.inject.Inject

class GetUpcomingEventsUseCaseImpl @Inject constructor(
    private val eventsRepository: EventsRepository
) : GetUpcomingEventsUseCase {
    override suspend fun execute(): UpcomingEventsResult {
        return eventsRepository.getUpcomingEvents()
    }
}