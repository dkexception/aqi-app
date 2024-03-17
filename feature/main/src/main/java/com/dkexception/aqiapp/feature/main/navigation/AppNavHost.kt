package com.dkexception.aqiapp.feature.main.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.dkexception.aqiapp.feature.onboarding.navigation.onboardingNavGraph
import com.dkexception.core.navigation.NavRoute

@Composable
fun AppNavHost(
    navController: NavHostController
) = NavHost(
    navController = navController,
    startDestination = NavRoute.ONBOARDING.ROOT,
    modifier = Modifier.fillMaxSize()
) {

    onboardingNavGraph()
}
