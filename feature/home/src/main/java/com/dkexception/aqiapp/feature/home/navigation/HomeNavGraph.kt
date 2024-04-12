package com.dkexception.aqiapp.feature.home.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import com.dkexception.aqiapp.feature.home.home.HomeScreen
import com.dkexception.aqiapp.feature.home.home.HomeScreenState
import com.dkexception.aqiapp.feature.home.home.HomeViewModel
import com.dkexception.core.base.mvi.baseComposable
import com.dkexception.core.navigation.NavRoute

fun NavGraphBuilder.homeNavGraph() = baseComposable(
    route = NavRoute.HOME.ROOT
) {

    val viewModel: HomeViewModel = hiltViewModel()
    val state: HomeScreenState by viewModel.state.collectAsStateWithLifecycle()

    HomeScreen(
        state = state,
        aqiIAQIDetailsCard = viewModel.aqiIAQIDetailsCard,
        onEvent = viewModel::onEvent
    )
}
