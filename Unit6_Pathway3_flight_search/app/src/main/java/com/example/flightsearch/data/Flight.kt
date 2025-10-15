package com.example.flightsearch.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flights")
data class Flight(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val departureCode: String,
    val destinationCode: String,
    val price: Int,
    val isFavorite: Boolean = false
)
