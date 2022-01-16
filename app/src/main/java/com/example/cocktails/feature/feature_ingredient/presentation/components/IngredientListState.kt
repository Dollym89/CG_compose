package com.example.cocktails.feature.feature_ingredient.presentation.components

import com.example.cocktails.feature.feature_ingredient.domain.model.Ingredient

data class IngredientListState(
    val ingredients: List<Ingredient> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
    val isFilterToggled: Boolean = false,
)
