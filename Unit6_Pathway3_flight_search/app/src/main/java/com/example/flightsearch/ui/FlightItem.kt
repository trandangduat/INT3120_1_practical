package com.example.flightsearch.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flightsearch.data.Flight

@Composable
fun FlightItem(flight: Flight, onFavorite: (Flight) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("${flight.departureCode} → ${flight.destinationCode} (${flight.price}$)")
            IconButton(onClick = { onFavorite(flight) }) {
                val icon = if (flight.isFavorite) Icons.Default.Star else Icons.Default.StarBorder
                Icon(icon, contentDescription = "Favorite")
            }
        }
    }
}
