package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource.dessertList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertClickerViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DessertClickerUiState())
    val uiState: StateFlow<DessertClickerUiState> = _uiState.asStateFlow()

    fun onDessertClicked() {
        _uiState.update { cupcakeUiState ->
        val dessertsSold = cupcakeUiState.dessertsSold + 1
        val nextDessertIndex = getDessertIndex(dessertsSold)
        cupcakeUiState.copy(
            currentDessertIndex = nextDessertIndex,
            revenue = cupcakeUiState.revenue + cupcakeUiState.currentDessertPrice,
            dessertsSold = dessertsSold,
            currentDessertImageId = dessertList[nextDessertIndex].imageId,
            currentDessertPrice = dessertList[nextDessertIndex].price
        )
    }
}
private fun getDessertIndex(dessertsSold: Int): Int {
        var dessertIndex = 0
        for (index in dessertList.indices) {
            if (dessertsSold >= dessertList[index].startProductionAmount) {
                dessertIndex = index
            } else {
                break
            }
        }
        return dessertIndex
    }

}