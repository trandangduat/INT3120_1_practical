package com.example.flightsearch.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.flightsearch.ui.FlightSearchViewModel
import com.example.flightsearch.ui.screens.SearchScreen

@Composable
fun NavGraph(viewModel: FlightSearchViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "search") {
        composable("search") {
            SearchScreen(viewModel)
        }
    }
}
