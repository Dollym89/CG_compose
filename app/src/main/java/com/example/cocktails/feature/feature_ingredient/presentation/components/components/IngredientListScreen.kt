package com.example.cocktails.feature.feature_ingredient.presentation.components.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.example.cocktails.feature.feature_filter.presentation.components.Filter
import com.example.cocktails.feature.feature_ingredient.presentation.components.IngredientListViewModel
import com.example.cocktails.feature.feature_ingredient.presentation.components.IngredientListViewModel.UiEvent

@ExperimentalAnimationApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun IngredientListScreen(
    viewModel: IngredientListViewModel = hiltViewModel()

) {

    val state = viewModel.state.value

    val scaffoldState = rememberScaffoldState()
    //TODO scaffol only because of floating button and toasts later on

    var isFilterToggled by remember {
        mutableStateOf(false)
    }

    Scaffold(scaffoldState = scaffoldState) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Ingredients",
                    modifier = Modifier.padding(6.dp)
                )

                IconButton(onClick = { isFilterToggled = !isFilterToggled }
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Filter Icon"
                    )
                }
            }
            Filter(isFilterToggled = isFilterToggled)

            Box(modifier = Modifier.fillMaxSize()) {
                LazyVerticalGrid(
                    cells = GridCells.Fixed(2)
                ) {
                    items(state.ingredients) { ingredient ->
                        IngredientListItem(
                            ingredient = ingredient,
                            onItemClick = {}
                        )
                    }
                }
                if (state.error.isNotBlank()) {
                    Text(
                        text = state.error,
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.Center)
                    )
                }
                if (state.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}
