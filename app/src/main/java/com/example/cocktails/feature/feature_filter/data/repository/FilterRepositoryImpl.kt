package com.example.cocktails.feature.feature_filter.data.repository

import com.example.cocktails.feature.feature_filter.domain.model.FilterItem
import com.example.cocktails.feature.feature_filter.domain.model.MainFilterItem
import com.example.cocktails.feature.feature_filter.domain.use_case.FilterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class FilterRepositoryImpl @Inject constructor() : FilterRepository {

    override fun provideMainFilter(): Flow<List<MainFilterItem>> = createMainFilter()

    // TODO just a dummy repo
    private fun createMainFilter() = flow {
        Timber.e("FilterRepositoryImpl")
        emit(
            (1..2).map { id ->
                when (id) {
                    1 -> {
                        MainFilterItem(
                            item = createFilterItem("GLASS TYPE", id),
                            subItems = (1..6).map { createFilterItem(it.toString(), it) },
                        )
                    }
                    2 -> {
                        MainFilterItem(
                            item = createFilterItem("ALCO TYPE", id),
                            subItems = (66..95).map { createFilterItem(it.toString(), it) },
                        )
                    }
                    else -> {
                        MainFilterItem(
                            item = createFilterItem("ELSE TYPE", id),
                            subItems = (22..26).map { createFilterItem(it.toString(), it) },
                        )
                    }
                }
            }
        )
    }

    private fun createFilterItem(name: String, id: Int) =
        FilterItem(
            id = id,
            name = name
        )
}
