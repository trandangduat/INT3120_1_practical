package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.AppUiState
import com.example.mycity.data.DataProvider
import com.example.mycity.data.Recommendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState())
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    fun fetchPlaceList(category: String) {
        _uiState.update { currentState ->
            currentState.copy(
                placeList = DataProvider.getRecommendations(category)
            )
        }
    }

    fun fetchPlaceInfo(placeId: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                currentPlace = currentState.placeList.find { recommendation ->
                    recommendation.id == placeId
                } ?: Recommendation(id = 0, title = "", description = "")
            )
        }
    }

}