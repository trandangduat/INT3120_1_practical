package com.example.flightsearch.data

import androidx.room.*

@Dao
interface FlightDao {
    @Query("SELECT * FROM airport WHERE name LIKE '%' || :query || '%' OR iata_code LIKE '%' || :query || '%' ORDER BY passengers DESC")
    suspend fun searchAirports(query: String): List<Airport>

    @Query("""
        SELECT * FROM airport 
        WHERE iata_code != :departureCode
        ORDER BY passengers DESC
    """)
    suspend fun getDestinations(departureCode: String): List<Airport>

    @Query("SELECT * FROM favorite")
    suspend fun getFavorites(): List<Favorite>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(favorite: Favorite)

    @Delete
    suspend fun deleteFavorite(favorite: Favorite)
}
