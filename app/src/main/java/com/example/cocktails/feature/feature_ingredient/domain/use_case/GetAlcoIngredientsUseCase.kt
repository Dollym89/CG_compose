package com.example.cocktails.feature.feature_ingredient.domain.use_case

import com.example.cocktails.common.Resource
import com.example.cocktails.feature.feature_ingredient.domain.model.Ingredient
import com.example.cocktails.feature.feature_ingredient.domain.repository.IngredientRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAlcoIngredientsUseCase @Inject constructor(
    private val repository: IngredientRepository,
) {

    suspend operator fun invoke(): Flow<Resource<List<Ingredient>>> {
        return repository.getAlcoIngredients()
    }
}
