package com.biggerthannull.myadventure.domain.usecase

import com.biggerthannull.myadventure.domain.usecase.model.UpcomingEventsResult

interface GetUpcomingEventsUseCase {
    fun execute(): UpcomingEventsResult
}