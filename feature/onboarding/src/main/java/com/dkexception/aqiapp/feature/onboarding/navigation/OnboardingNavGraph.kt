package com.dkexception.aqiapp.feature.onboarding.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.dkexception.aqiapp.feature.onboarding.guide.GuideScreen
import com.dkexception.aqiapp.feature.onboarding.guide.GuideViewModel
import com.dkexception.aqiapp.feature.onboarding.welcome.WelcomeScreen
import com.dkexception.aqiapp.feature.onboarding.welcome.WelcomeViewModel
import com.dkexception.core.base.mvi.baseComposable
import com.dkexception.core.navigation.NavRoute

fun NavGraphBuilder.onboardingNavGraph() = navigation(
    route = NavRoute.ONBOARDING.ROOT,
    startDestination = NavRoute.ONBOARDING.WELCOME
) {

    baseComposable(NavRoute.ONBOARDING.WELCOME) {

        val viewModel: WelcomeViewModel = hiltViewModel()
        WelcomeScreen()
    }

    baseComposable(NavRoute.ONBOARDING.GUIDE) {

        val viewModel: GuideViewModel = hiltViewModel()
        GuideScreen(viewModel::onEvent)
    }
}
