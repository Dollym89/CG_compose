package com.example.cocktails.feature.feature_filter.domain.use_case

import com.example.cocktails.feature.feature_filter.domain.model.MainFilterItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class FilterUseCase @Inject constructor(
    private val repository: FilterRepository
) {
    operator fun invoke(): Flow<List<MainFilterItem>> = repository.provideMainFilter()
}
