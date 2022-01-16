package com.example.cocktails.feature.feature_ingredient.presentation.components

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktails.common.Resource
import com.example.cocktails.feature.feature_ingredient.domain.model.Ingredient
import com.example.cocktails.feature.feature_ingredient.domain.use_case.GetAlcoIngredientsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

private typealias IngredientState = MutableState<IngredientListState>

@HiltViewModel
class IngredientListViewModel @Inject constructor(
    private val getAlcoIngredientsUseCase: GetAlcoIngredientsUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(IngredientListState())
    val state: State<IngredientListState> = _state

    init {
        viewModelScope.launch { getIngredient().collect() }
    }

    private suspend fun getIngredient(): Flow<Resource<List<Ingredient>>> {
        return getAlcoIngredientsUseCase().onEach { ingredient ->
            when (ingredient) {
                is Resource.Success -> _state.onSuccess(ingredient)
                is Resource.Error -> _state.onError()
                is Resource.Loading -> _state.onLoading()
            }
        }
    }

    private fun IngredientState.onLoading() {
        value = state.value.copy(
            ingredients = emptyList(),
            isLoading = true
        )
    }

    private fun IngredientState.onError() {
        value = state.value.copy(
            ingredients = emptyList(),
            isLoading = false,
            error = "An unexpected error occured"
        )
    }

    private fun IngredientState.onSuccess(ingredient: Resource<List<Ingredient>>) {
        _state.value = state.value.copy(
            ingredients = ingredient.data ?: emptyList(),
            isLoading = false,
            isFilterToggled = false
        )
    }

    fun onEvent(event: UiEvent) {
        when (event) {
            is UiEvent.ToggleFilter -> {
                _state.value = state.value.copy(isFilterToggled = !state.value.isFilterToggled)
            }

            is UiEvent.HideFilter -> {
                _state.value = state.value.copy(isFilterToggled = !state.value.isFilterToggled)
            }
        }
    }

    sealed class UiEvent {
        object ToggleFilter : UiEvent()
        object HideFilter : UiEvent()
    }
}
