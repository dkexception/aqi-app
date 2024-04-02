package com.dkexception.aqiapp.feature.dashboard.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.dkexception.aqiapp.feature.dashboard.home.HomeScreen
import com.dkexception.aqiapp.feature.dashboard.home.HomeScreenState
import com.dkexception.aqiapp.feature.dashboard.home.HomeViewModel
import com.dkexception.core.base.mvi.baseComposable
import com.dkexception.core.navigation.NavRoute

fun NavGraphBuilder.dashboardNavGraph() = navigation(
    route = NavRoute.DASHBOARD.ROOT,
    startDestination = NavRoute.DASHBOARD.HOME
) {

    baseComposable(NavRoute.DASHBOARD.HOME) {

        val viewModel: HomeViewModel = hiltViewModel()
        val state: HomeScreenState by viewModel.state.collectAsStateWithLifecycle()

        HomeScreen(
            state = state,
            mMapView = viewModel.mMapView,
            onEvent = viewModel::onEvent
        )
    }
}
