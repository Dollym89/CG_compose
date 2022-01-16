package com.example.cocktails.feature.feature_filter.presentation.components

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cocktails.common.ui.components.ButtonState
import com.example.cocktails.common.ui.components.Chip
import com.example.cocktails.feature.feature_filter.presentation.FilterViewModel
import com.example.cocktails.feature.feature_filter.presentation.FilterViewModel.FilterUiEvent

@ExperimentalAnimationApi
@Composable
fun Filter(
    isFilterToggled: Boolean,
    viewModel: FilterViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        AnimatedVisibility(
            visible = isFilterToggled,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically()
        ) {
            state.filterItems.let { filter ->
                Row {
                    filter.forEach { mainFilter ->
                        Chip(text = mainFilter.item.name, btnState = mainFilter.item.btnState) {

                            if (mainFilter.item.btnState == ButtonState.PRESSED) {
                                viewModel.onEvent(FilterUiEvent.HideSubFilter(mainFilter.item.id))
                            } else {
                                viewModel.onEvent(FilterUiEvent.ToggleSubFilter(mainFilter.item.id))
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        LaunchedEffect(key1 = isFilterToggled && state.lastTab != null) {

        }


//        AnimatedVisibility(
//            visible = isFilterToggled && state.lastTab != null,
//            enter = fadeIn() + slideInVertically(),
//            exit = fadeOut() + slideOutVertically()
//        ) {
//            Row {
//                state.filterItems.find { it.item.id == state.lastTab }?.let { mainFilter ->
//                    mainFilter.subItems.forEach { subItem ->
//                        Chip(text = subItem.name, btnState = subItem.btnState) {
//                            viewModel.onEvent(FilterUiEvent.ToggleSubFilterItem(subItem.id, mainFilter.item.id))
//                        }
//                    }
//                }
//            }
//        }
    }
    Spacer(modifier = Modifier.height(12.dp))
}
