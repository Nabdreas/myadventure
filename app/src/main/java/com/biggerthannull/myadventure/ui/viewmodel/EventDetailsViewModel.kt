package com.biggerthannull.myadventure.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class EventDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val eventId by lazy {
        savedStateHandle.get<String>("event_id")
    }

    private val _uiState = MutableStateFlow("")
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.value = eventId ?: "Sorry you failed to pass a param"
    }
}