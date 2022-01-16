package com.example.cocktails.feature.feature_ingredient.domain.repository

import com.example.cocktails.common.Resource
import com.example.cocktails.feature.feature_ingredient.domain.model.Ingredient
import kotlinx.coroutines.flow.Flow

interface IngredientRepository {
    suspend fun getAlcoIngredients(): Flow<Resource<List<Ingredient>>>
    suspend fun getAlcoIngredientsById(ingredientId: String): Flow<Resource<Ingredient>>
//    suspend fun getNonAlcoIngredients(): List<Ingredient>
//    suspend fun getNonAlcoIngredientsById(ingredientId: String): Ingredient
}
