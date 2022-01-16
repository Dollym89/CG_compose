package com.example.cocktails.feature.feature_filter.domain.use_case

import com.example.cocktails.feature.feature_filter.domain.model.MainFilterItem
import kotlinx.coroutines.flow.Flow

interface FilterRepository {
    fun provideMainFilter(): Flow<List<MainFilterItem>>
}
