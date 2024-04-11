package com.dkexception.aqiapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.dkexception.aqiapp.feature.aqidetails.navigation.aqiDetailsNavGraph
import com.dkexception.aqiapp.feature.auth.navigation.authNavGraph
import com.dkexception.aqiapp.feature.databank.navigation.dataBankNavGraph
import com.dkexception.aqiapp.feature.more.navigation.moreNavGraph
import com.dkexception.aqiapp.feature.home.navigation.homeNavGraph
import com.dkexception.aqiapp.feature.onboarding.navigation.onboardingNavGraph
import com.dkexception.core.navigation.NavRoute
import com.dkexception.ui.navigation.DXNavTransitions

@Composable
fun AQIAppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) = NavHost(
    navController = navController,
    startDestination = NavRoute.ONBOARDING.ROOT,
    modifier = modifier,
    enterTransition = DXNavTransitions.enterTransition,
    exitTransition = DXNavTransitions.exitTransition,
    popEnterTransition = DXNavTransitions.popEnterTransition,
    popExitTransition = DXNavTransitions.popExitTransition
) {

    onboardingNavGraph()

    authNavGraph()

    homeNavGraph()

    dataBankNavGraph()

    moreNavGraph()

    aqiDetailsNavGraph()
}
