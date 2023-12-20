package com.biggerthannull.myadventure.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biggerthannull.myadventure.domain.usecase.GetUpcomingEventsUseCase
import com.biggerthannull.myadventure.domain.usecase.model.UpcomingEventsResult
import com.biggerthannull.myadventure.ui.viewmodel.events.HomeScreenUserEvents
import com.biggerthannull.myadventure.ui.viewmodel.model.HomeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getUpcomingEventsUseCase: GetUpcomingEventsUseCase
) : ViewModel(), HomeScreenUserEvents {

    private val _uiState = MutableStateFlow<HomeUIState>(HomeUIState.Loading)
    val uiState = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            val result = getUpcomingEventsUseCase.execute()
            _uiState.value = if (result is UpcomingEventsResult.Success) {
                HomeUIState.Loaded(
                    upcomingEvents = result.upcomingEvents
                )
            } else {
                HomeUIState.Error
            }
        }
    }

    override fun selectEvent(eventId: String) {
        Log.d("HomeViewModel", eventId)
    }
}