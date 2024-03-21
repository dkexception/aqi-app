package com.dkexception.aqiapp.feature.auth.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.dkexception.aqiapp.feature.auth.login.LoginScreen
import com.dkexception.aqiapp.feature.auth.login.LoginState
import com.dkexception.aqiapp.feature.auth.login.LoginViewModel
import com.dkexception.core.base.mvi.baseComposable
import com.dkexception.core.navigation.NavRoute

fun NavGraphBuilder.authNavGraph() = navigation(
    route = NavRoute.AUTH.ROOT,
    startDestination = NavRoute.AUTH.LOGIN
) {

    baseComposable(NavRoute.AUTH.LOGIN) {

        val viewModel: LoginViewModel = hiltViewModel()
        val state: LoginState by viewModel.state.collectAsStateWithLifecycle()
        LoginScreen(state = state, onEvent = viewModel::onEvent)
    }
}
