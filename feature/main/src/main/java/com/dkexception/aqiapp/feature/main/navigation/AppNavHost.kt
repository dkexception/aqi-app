package com.dkexception.aqiapp.feature.main.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.dkexception.aqiapp.feature.auth.navigation.authNavGraph
import com.dkexception.aqiapp.feature.dashboard.navigation.dashboardNavGraph
import com.dkexception.aqiapp.feature.more.navigation.moreNavGraph
import com.dkexception.aqiapp.feature.onboarding.navigation.onboardingNavGraph
import com.dkexception.core.navigation.NavRoute
import com.dkexception.ui.navigation.DXNavTransitions

@Composable
fun AppNavHost(
    navController: NavHostController
) = NavHost(
    navController = navController,
    startDestination = NavRoute.ONBOARDING.ROOT,
    modifier = Modifier.fillMaxSize(),
    enterTransition = DXNavTransitions.enterTransition,
    exitTransition = DXNavTransitions.exitTransition,
    popEnterTransition = DXNavTransitions.popEnterTransition,
    popExitTransition = DXNavTransitions.popExitTransition
) {

    onboardingNavGraph()

    authNavGraph()

    dashboardNavGraph()

    moreNavGraph()
}
