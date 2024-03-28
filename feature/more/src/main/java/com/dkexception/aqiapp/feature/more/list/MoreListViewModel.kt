package com.dkexception.aqiapp.feature.more.list

import com.dkexception.core.base.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MoreListViewModel @Inject constructor(

) : BaseViewModel<MoreListEvent>() {

    private val _state = MutableStateFlow(MoreListScreenState())
    val state: StateFlow<MoreListScreenState> get() = _state.asStateFlow()

    override fun onEvent(event: MoreListEvent) {
        when (event) {
            is MoreListEvent.OnItemClicked -> {

            }
        }
    }
}
