package com.example.flightsearch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightsearch.data.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FlightSearchViewModel(
    private val repository: FlightRepository,
    private val prefs: UserPreferencesRepository
) : ViewModel() {

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query

    private val _airports = MutableStateFlow<List<Airport>>(emptyList())
    val airports: StateFlow<List<Airport>> = _airports

    private val _flights = MutableStateFlow<List<Airport>>(emptyList())
    val flights: StateFlow<List<Airport>> = _flights

    private val _favorites = MutableStateFlow<List<Favorite>>(emptyList())
    val favorites: StateFlow<List<Favorite>> = _favorites

    private var selectedDeparture: Airport? = null

    init {
        viewModelScope.launch {
            // Load last query + favorites
            combine(prefs.searchQuery, repository.getFavorites()) { saved, favs ->
                _query.value = saved
                _favorites.value = favs
                if (saved.isNotEmpty()) searchAirports(saved)
            }.collect()
        }
    }

    fun updateQuery(newQuery: String) {
        _query.value = newQuery
        viewModelScope.launch {
            prefs.saveSearchQuery(newQuery)
            searchAirports(newQuery)
        }
    }

    private suspend fun searchAirports(q: String) {
        repository.searchAirports(q).collect { _airports.value = it }
    }

    fun selectDeparture(airport: Airport) {
        selectedDeparture = airport
        viewModelScope.launch {
            repository.getDestinations(airport.iata_code).collect { _flights.value = it }
        }
    }

    fun toggleFavorite(destination: Airport) {
        selectedDeparture?.let { dep ->
            viewModelScope.launch {
                repository.toggleFavorite(dep.iata_code, destination.iata_code)
                repository.getFavorites().collect { _favorites.value = it }
            }
        }
    }
}
