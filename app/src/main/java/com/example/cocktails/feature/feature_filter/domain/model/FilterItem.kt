package com.example.cocktails.feature.feature_filter.domain.model

import com.example.cocktails.common.ui.components.ButtonState

data class FilterItem(
    val id: Int,
    val name: String,
    var btnState: ButtonState = ButtonState.IDLE
)

data class MainFilterItem(
    val item: FilterItem,
    val subItems: List<FilterItem> = emptyList(),
)
