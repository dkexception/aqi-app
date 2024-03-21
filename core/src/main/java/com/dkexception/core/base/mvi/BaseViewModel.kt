package com.dkexception.core.base.mvi

import androidx.lifecycle.ViewModel
import com.dkexception.core.navigation.NavigationManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

abstract class BaseViewModel<Event, State> : ViewModel() {

    @Inject
    lateinit var navigationManager: NavigationManager

    protected abstract val mState: MutableStateFlow<State>
    val state: StateFlow<State> get() = mState.asStateFlow()

    open fun onEvent(event: Event) = Unit

    protected fun updateState(newState: (currentState: State) -> State) {
        mState.update { state ->
            newState(state)
        }
    }
}
