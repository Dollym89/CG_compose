package com.example.cocktails.feature.feature_ingredient.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cocktails.feature.feature_ingredient.data.local.entity.IngredientEntity

@Database(
    entities = [IngredientEntity::class],
    version = 1
)
abstract class IngredientDatabase : RoomDatabase() {
    abstract val dao: IngredientDao
}
