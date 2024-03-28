package com.dkexception.aqiapp.feature.more.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.dkexception.aqiapp.feature.more.list.MoreListScreen
import com.dkexception.aqiapp.feature.more.list.MoreListScreenState
import com.dkexception.aqiapp.feature.more.list.MoreListViewModel
import com.dkexception.core.base.mvi.baseComposable
import com.dkexception.core.navigation.NavRoute

fun NavGraphBuilder.moreNavGraph() = navigation(
    route = NavRoute.MORE.ROOT,
    startDestination = NavRoute.MORE.LIST
) {

    baseComposable(NavRoute.MORE.LIST) {

        val viewModel: MoreListViewModel = hiltViewModel()
        val state: MoreListScreenState by viewModel.state.collectAsStateWithLifecycle()
        MoreListScreen(state = state, onEvent = viewModel::onEvent)
    }
}
