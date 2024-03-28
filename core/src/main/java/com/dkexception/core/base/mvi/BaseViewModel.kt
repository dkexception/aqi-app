package com.dkexception.core.base.mvi

import androidx.lifecycle.ViewModel
import com.dkexception.core.navigation.NavigationManager
import javax.inject.Inject

abstract class BaseViewModel<Event> : ViewModel() {

    @Inject
    lateinit var navigationManager: NavigationManager

    open fun onEvent(event: Event) = Unit
}
