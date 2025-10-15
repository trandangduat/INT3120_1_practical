package com.example.flightsearch.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flightsearch.data.Airport
import com.example.flightsearch.data.Favorite
import com.example.flightsearch.ui.FlightSearchViewModel

@Composable
fun SearchScreen(viewModel: FlightSearchViewModel) {
    val query by viewModel.query.collectAsState()
    val airports by viewModel.airports.collectAsState()
    val flights by viewModel.flights.collectAsState()
    val favorites by viewModel.favorites.collectAsState()

    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = { viewModel.updateQuery(it) },
            label = { Text("Search airport or IATA code") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        when {
            query.isEmpty() -> {
                Text("Favorite Routes", style = MaterialTheme.typography.titleMedium)
                favorites.forEach {
                    FavoriteItem(it)
                }
            }
            flights.isEmpty() -> {
                Text("Airports", style = MaterialTheme.typography.titleMedium)
                airports.forEach { airport ->
                    AirportItem(airport) { viewModel.selectDeparture(airport) }
                }
            }
            else -> {
                Text("Flights from selected airport", style = MaterialTheme.typography.titleMedium)
                flights.forEach { dest ->
                    FlightItem(
                        departure = viewModel.query.value,
                        destination = dest,
                        onFavorite = { viewModel.toggleFavorite(dest) }
                    )
                }
            }
        }
    }
}

@Composable
fun AirportItem(airport: Airport, onClick: (Airport) -> Unit) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick(airport) }
    ) {
        Column(Modifier.padding(8.dp)) {
            Text("${airport.name} (${airport.iata_code})")
            Text("${airport.passengers} passengers/year", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun FlightItem(departure: String, destination: Airport, onFavorite: () -> Unit) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("$departure → ${destination.iata_code} (${destination.name})")
            IconButton(onClick = onFavorite) {
                Icon(Icons.Default.StarBorder, contentDescription = "Add favorite")
            }
        }
    }
}

@Composable
fun FavoriteItem(fav: Favorite) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("${fav.departure_code} → ${fav.destination_code}")
            Icon(Icons.Default.Star, contentDescription = "Favorite")
        }
    }
}
