package com.dkexception.aqiapp.feature.databank.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.dkexception.aqiapp.feature.databank.main.DataBankMainScreen
import com.dkexception.aqiapp.feature.databank.main.DataBankMainScreenState
import com.dkexception.aqiapp.feature.databank.main.DataBankMainViewModel
import com.dkexception.core.base.mvi.baseComposable
import com.dkexception.core.navigation.NavRoute

fun NavGraphBuilder.dataBankNavGraph() = navigation(
    route = NavRoute.DATABANK.ROOT,
    startDestination = NavRoute.DATABANK.MAIN
) {

    baseComposable(NavRoute.DATABANK.MAIN) {

        val viewModel: DataBankMainViewModel = hiltViewModel()
        val state: DataBankMainScreenState by viewModel.state.collectAsStateWithLifecycle()

        DataBankMainScreen(state = state, onEvent = viewModel::onEvent)
    }
}
