package com.dkexception.aqiapp.feature.dashboard.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.dkexception.core.base.mvi.baseComposable
import com.dkexception.core.navigation.NavRoute

fun NavGraphBuilder.dashboardNavGraph() = navigation(
    route = NavRoute.DASHBOARD.ROOT,
    startDestination = NavRoute.DASHBOARD.HOME
) {

    baseComposable(NavRoute.DASHBOARD.HOME) {

    }
}
