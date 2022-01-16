package com.example.cocktails.feature.feature_filter.di

import com.example.cocktails.feature.feature_filter.data.repository.FilterRepositoryImpl
import com.example.cocktails.feature.feature_filter.domain.use_case.FilterRepository
import com.example.cocktails.feature.feature_filter.domain.use_case.FilterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FilterModule {

    @Provides
    @Singleton
    fun providesFilterRepository(): FilterRepository {
        return FilterRepositoryImpl()
    }

    @Provides
    @Singleton
    fun providesFilterUseCase(repository: FilterRepository): FilterUseCase {
        return FilterUseCase(repository)
    }
}
