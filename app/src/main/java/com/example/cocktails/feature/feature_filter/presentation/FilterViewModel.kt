package com.example.cocktails.feature.feature_filter.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktails.common.ui.components.ButtonState
import com.example.cocktails.feature.feature_filter.domain.model.MainFilterItem
import com.example.cocktails.feature.feature_filter.domain.use_case.FilterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor(
    private val filterUseCase: FilterUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(FilterState())
    val state: State<FilterState> = _state

    init {
        viewModelScope.launch { getFilterValues().collect() }
    }

    private fun getFilterValues(): Flow<List<MainFilterItem>> =
        filterUseCase().onEach {
            _state.value = FilterState(
                filterItems = it,
            )
        }

    fun onEvent(uiEvent: FilterUiEvent) {
        when (uiEvent) {
            is FilterUiEvent.ToggleSubFilter -> {
                _state.value =
                    state.value.copy(
                        filterItems = _state.value.filterItems.apply {
                            find { it.item.id == uiEvent.id }?.item?.btnState = ButtonState.PRESSED
                        },
                        selectedTabs = _state.value.selectedTabs.apply { add(uiEvent.id) },
                        lastTab = uiEvent.id
                    )
            }
            is FilterUiEvent.HideSubFilter -> {
                _state.value = state.value.copy(
                    filterItems = _state.value.filterItems.apply {
                        find { it.item.id == uiEvent.id }?.item?.btnState = ButtonState.IDLE
                    },
                    selectedTabs = _state.value.selectedTabs.apply { remove(uiEvent.id) },
                    lastTab = if (_state.value.selectedTabs.isNotEmpty()) _state.value.selectedTabs.first() else null
                )
            }
            is FilterUiEvent.ToggleSubFilterItem -> {
                _state.value = state.value.copy(
                    filterItems = _state.value.filterItems.apply {
                        find { it.item.id == uiEvent.mainId }?.subItems?.forEach {
                            if (it.id == uiEvent.subId) it.btnState = ButtonState.PRESSED
                            else it.btnState = ButtonState.IDLE
                        }
                    }
                )
            }
        }
    }

    sealed class FilterUiEvent {
        class ToggleSubFilter(val id: Int) : FilterUiEvent()
        class HideSubFilter(val id: Int) : FilterUiEvent()
        class ToggleSubFilterItem(val subId: Int, val mainId: Int) : FilterUiEvent()
    }

    data class FilterState(
        val filterItems: List<MainFilterItem> = mutableListOf(),
        val selectedTabs: MutableList<Int> = mutableListOf(),
        val lastTab: Int? = null
    )
}
