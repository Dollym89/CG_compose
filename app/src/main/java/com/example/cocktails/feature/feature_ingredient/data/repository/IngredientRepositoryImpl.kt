package com.example.cocktails.feature.feature_ingredient.data.repository

import com.example.cocktails.common.Resource
import com.example.cocktails.common.data.ListMapper
import com.example.cocktails.feature.feature_ingredient.data.IngredientApi
import com.example.cocktails.feature.feature_ingredient.data.local.IngredientDao
import com.example.cocktails.feature.feature_ingredient.data.mapper.IngredientDtoMapper
import com.example.cocktails.feature.feature_ingredient.data.mapper.IngredientDtoMapper.convert
import com.example.cocktails.feature.feature_ingredient.data.mapper.IngredientEntityMapper
import com.example.cocktails.feature.feature_ingredient.data.mapper.IngredientEntityMapper.convert
import com.example.cocktails.feature.feature_ingredient.domain.model.Ingredient
import com.example.cocktails.feature.feature_ingredient.domain.repository.IngredientRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class IngredientRepositoryImpl @Inject constructor(
    private val ingredientApi: IngredientApi,
    private val dao: IngredientDao,
    private val dtoMapper: IngredientDtoMapper,
    private val entityMapper: IngredientEntityMapper
) : IngredientRepository {

    override suspend fun getAlcoIngredients(): Flow<Resource<List<Ingredient>>> =
        flow {
            emit(Resource.Loading<List<Ingredient>>())

            val ingredients: List<Ingredient> = dao.getAll().map { it.convert() }

            emit(Resource.Loading(data = ingredients))
            if (ingredients.isEmpty()) {
                ingredientApi.getAllAlcoholic()
                    .runCatching {
                        let(ListMapper(dtoMapper)).also { dao.insertAll(it) }
                    }.onSuccess {
                        emit(Resource.Success<List<Ingredient>>(it.let(ListMapper(entityMapper))))
                    }.onFailure {
                        it.captureException()
                    }
            } else {
                emit(Resource.Success(data = ingredients))
            }
        }

    override suspend fun getAlcoIngredientsById(ingredientId: String): Flow<Resource<Ingredient>> =
        flow {
            emit(Resource.Loading())
            ingredientApi.getAlcoholicById(ingredientId).runCatching {
                convert()
            }.onSuccess {
                emit(Resource.Success<Ingredient>(it.convert()))
            }.onFailure {
                it.captureException()
            }
        }

    private fun Throwable.captureException(): Flow<Resource<Ingredient>> = flow {
        when (this) {
            is HttpException -> emit(
                Resource.Error<Ingredient>(localizedMessage ?: "An unexpected error occcured")
            )
            is IOError -> emit(Resource.Error<Ingredient>("Check your internet connection"))
            else -> throw this@captureException
        }
    }
}
