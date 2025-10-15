package com.example.flightsearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.flightsearch.data.*
import com.example.flightsearch.ui.FlightSearchViewModel
import com.example.flightsearch.ui.screens.SearchScreen
import com.example.flightsearch.ui.theme.FlightSearchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = FlightDatabase.getDatabase(applicationContext)
        val repository = FlightRepository(db.flightDao())
        val prefs = UserPreferencesRepository(applicationContext)
        val viewModel = FlightSearchViewModel(repository, prefs)

        setContent {
            FlightSearchTheme {
                SearchScreen(viewModel)
            }
        }
    }
}
