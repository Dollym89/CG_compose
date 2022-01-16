package com.example.cocktails.feature.feature_ingredient.data

import com.example.cocktails.feature.feature_ingredient.data.remote.dto.IngredientDto
import retrofit2.http.GET
import retrofit2.http.Query

interface IngredientApi {
    @GET("/ingredient/alcoholic/all")
    suspend fun getAllAlcoholic(): List<IngredientDto>

    @GET("/ingredient/non-alcoholic/all")
    suspend fun getAllNonAlcoholic(): List<IngredientDto>

    @GET("/ingredient/alcoholic")
    suspend fun getAlcoholicById(@Query("id") id: String): IngredientDto

    @GET("/ingredient/non-alcoholic")
    suspend fun getNonAlcoholicById(@Query("id") id: String): IngredientDto
}
