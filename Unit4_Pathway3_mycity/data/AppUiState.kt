package com.example.mycity.data

data class AppUiState(
    var categories: List<String> = DataProvider.getCategories(),
    val placeList: List<Recommendation> = emptyList(),
    val currentPlace: Recommendation = Recommendation(id = 0, title = "", description = ""),
)
