package com.example.flightsearch.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FlightRepository(private val dao: FlightDao) {

    fun searchAirports(query: String): Flow<List<Airport>> = flow {
        emit(dao.searchAirports(query))
    }

    fun getDestinations(from: String): Flow<List<Airport>> = flow {
        emit(dao.getDestinations(from))
    }

    fun getFavorites(): Flow<List<Favorite>> = flow {
        emit(dao.getFavorites())
    }

    suspend fun toggleFavorite(departure: String, destination: String) {
        val current = dao.getFavorites()
            .find { it.departure_code == departure && it.destination_code == destination }
        if (current != null) dao.deleteFavorite(current)
        else dao.addFavorite(Favorite(departure_code = departure, destination_code = destination))
    }
}
