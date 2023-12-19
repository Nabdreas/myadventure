package com.biggerthannull.myadventure.ui.viewmodel.model

import com.biggerthannull.myadventure.domain.usecase.model.UpcomingEvent

sealed class HomeUIState {
    object Loading: HomeUIState()
    object Error: HomeUIState()
    data class Loaded(
        val upcomingEvents: List<UpcomingEvent> = emptyList()
    ): HomeUIState()
}
