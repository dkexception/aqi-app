package com.dkexception.aqiapp.feature.aqidetails.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.dkexception.aqiapp.feature.aqidetails.details.AQIDetailsScreen
import com.dkexception.aqiapp.feature.aqidetails.details.AQIDetailsScreenState
import com.dkexception.aqiapp.feature.aqidetails.details.AQIDetailsViewModel
import com.dkexception.aqiapp.feature.aqidetails.scale.AQIScaleScreen
import com.dkexception.aqiapp.feature.aqidetails.scale.AQIScaleScreenState
import com.dkexception.aqiapp.feature.aqidetails.scale.AQIScaleViewModel
import com.dkexception.core.base.mvi.baseComposable
import com.dkexception.core.navigation.NavRoute

fun NavGraphBuilder.aqiDetailsNavGraph() {

    baseComposable(
        route = "${NavRoute.DETAILS.AQI_DETAILS}?shouldUseIPLocation={shouldUseIPLocation}",
        arguments = listOf(
            navArgument("shouldUseIPLocation") {
                type = NavType.BoolType
            }
        )
    ) {

        val viewModel: AQIDetailsViewModel = hiltViewModel()
        val state: AQIDetailsScreenState by viewModel.state.collectAsStateWithLifecycle()

        AQIDetailsScreen(state = state, onEvent = viewModel::onEvent)
    }

    baseComposable(NavRoute.DETAILS.AQI_SCALE) {

        val viewModel: AQIScaleViewModel = hiltViewModel()
        val state: AQIScaleScreenState by viewModel.state.collectAsStateWithLifecycle()

        AQIScaleScreen(state = state, onEvent = viewModel::onEvent)
    }
}
