package com.biggerthannull.myadventure.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.biggerthannull.myadventure.ui.viewmodel.events.HomeScreenUserEvents
import com.biggerthannull.myadventure.ui.viewmodel.model.HomeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel(), HomeScreenUserEvents {

    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                isLoading = false,
                title = "My Adventures"
            )
        }
    }

    override fun selectEvent() {
        TODO("Not yet implemented")
    }
}