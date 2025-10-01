package com.example.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycity.data.DataProvider
import com.example.mycity.ui.AppViewModel
import com.example.mycity.ui.CategoryListScreen
import com.example.mycity.ui.DetailScreen
import com.example.mycity.ui.RecommendationListScreen
import com.example.mycity.ui.theme.MyCityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCityTheme {
                Surface {
                    MyCityApp()
                }
            }
        }
    }
}

@Composable
fun MyCityApp(viewModel: AppViewModel = viewModel()) {
    val navController = rememberNavController()
    val uiState by viewModel.uiState.collectAsState()

    NavHost(navController, startDestination = "categories") {
        composable("categories") {
            CategoryListScreen(
                categories = DataProvider.getCategories(),
                onCategoryClick = { category ->
                    viewModel.fetchPlaceList(category)
                    navController.navigate("recommendations/$category")
                }
            )
        }
        composable("recommendations/{category}") { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: ""
            RecommendationListScreen(
                category = category,
                list = uiState.placeList,
                onItemClick = { id ->
                    viewModel.fetchPlaceInfo(id)
                    navController.navigate("detail/$category/$id")
                },
                onBack = { navController.popBackStack() }
            )
        }
        composable("detail/{category}/{id}") { backStackEntry ->
            DetailScreen(
                recommendation = uiState.currentPlace,
                onBack = { navController.popBackStack() }
            )
        }
    }

}