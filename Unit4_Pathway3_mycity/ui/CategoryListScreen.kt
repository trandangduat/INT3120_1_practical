package com.example.mycity.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryListScreen(categories: List<String>, onCategoryClick: (String) -> Unit) {
    Log.d("lmao", "hihihi $categories")
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Chọn thành phố") })
        },
    ) {
        LazyColumn(contentPadding = it) {
            items(categories) { category ->
                Box(
                    modifier = Modifier.clickable { onCategoryClick(category) }
                ) {
                    Text(
                        text = category
                    )
                }
                HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
            }
        }
    }
}

