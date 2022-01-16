package com.example.cocktails.feature.feature_ingredient.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cocktails.feature.feature_ingredient.data.local.entity.IngredientEntity

@Dao
interface IngredientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(ingredients: List<IngredientEntity>)

    @Query("SELECT * FROM ingrediententity")
    suspend fun getAll(): List<IngredientEntity>

    @Query("SELECT * FROM ingrediententity WHERE id IN(:ingredients)")
    suspend fun getById(ingredients: List<Int>): IngredientEntity

    @Query("DELETE FROM ingrediententity")
    suspend fun deleteIngredients()
}
