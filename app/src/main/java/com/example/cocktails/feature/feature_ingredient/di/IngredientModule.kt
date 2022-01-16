package com.example.cocktails.feature.feature_ingredient.di

import android.app.Application
import androidx.room.Room
import com.example.cocktails.feature.feature_ingredient.data.IngredientApi
import com.example.cocktails.feature.feature_ingredient.data.local.IngredientDatabase
import com.example.cocktails.feature.feature_ingredient.data.mapper.IngredientDtoMapper
import com.example.cocktails.feature.feature_ingredient.data.mapper.IngredientEntityMapper
import com.example.cocktails.feature.feature_ingredient.data.repository.IngredientRepositoryImpl
import com.example.cocktails.feature.feature_ingredient.domain.repository.IngredientRepository
import com.example.cocktails.feature.feature_ingredient.domain.use_case.GetAlcoIngredientsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object IngredientModule {

    @Provides
    @Singleton
    fun provideIngredientRemoteSource(retrofit: Retrofit): IngredientApi {
        return retrofit.create(IngredientApi::class.java)
    }

    @Provides
    @Singleton
    fun provideIngredientUseCase(repository: IngredientRepository): GetAlcoIngredientsUseCase {
        return GetAlcoIngredientsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideIngredientRepository(
        ingredientApi: IngredientApi,
        dto: IngredientDtoMapper,
        database: IngredientDatabase,
        entity: IngredientEntityMapper
    ): IngredientRepository {
        return IngredientRepositoryImpl(ingredientApi, database.dao, dto, entity)
    }

    @Provides
    @Singleton
    fun provideIngredientDtoMapper(): IngredientDtoMapper {
        return IngredientDtoMapper
    }

    @Provides
    @Singleton
    fun provideIngredientEntityMapper(): IngredientEntityMapper {
        return IngredientEntityMapper
    }

    @Provides
    @Singleton
    fun providesIngredientDatabase(app: Application): IngredientDatabase {
        return Room.databaseBuilder(
            app, IngredientDatabase::class.java, "ingredients_database"
        ).build()
    }
}
