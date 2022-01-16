package com.example.cocktails

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.cocktails.common.ui.theme.CocktailsTheme
import com.example.cocktails.feature.bottomNav.presentation.BottomNavItem
import com.example.cocktails.feature.bottomNav.presentation.components.BottomNavigationBar
import com.example.cocktails.feature.feature_ingredient.presentation.components.components.IngredientListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @ExperimentalCoilApi
    @ExperimentalAnimationApi
    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CocktailsTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "Profile",
                                    route = "profile",
                                    icon = Icons.Default.PermIdentity
                                ),
                                BottomNavItem(
                                    name = "Discover",
                                    route = "discover",
                                    icon = Icons.Default.Explore
                                ),
                                BottomNavItem(
                                    name = "WatchList",
                                    route = "watchList",
                                    icon = Icons.Default.Bookmarks
                                ),
                            ),
                            navController = navController,
                            onItemClick = { navController.navigate(it.route) }
                        )
                    }
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}

@ExperimentalCoilApi
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "discover") {
        composable("profile") { IngredientListScreen() }
        composable("discover") { TopRatedScreen() }
        composable("watchList") { WatchListScreen() }
    }
}


// TODO move to appropriate folder once implemented,
// Just a place holder at the moment
@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Profile Screen")
    }
}

@Composable
fun TopRatedScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Discover")
    }
}

@Composable
fun WatchListScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Watch List Screen")
    }
}
