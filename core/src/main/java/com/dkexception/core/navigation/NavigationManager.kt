package com.dkexception.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigationManager @Inject constructor() {

    private var navController: NavController? = null

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    fun navigate(route: String) = try {
        navController?.navigate(route)
    } catch (e: IllegalArgumentException) {
        // do nothing
    }

    fun navigateWithNavOptions(route: String, navOptions: NavOptions) = try {
        navController?.navigate(route, navOptions)
    } catch (e: IllegalArgumentException) {
        // do nothing
    }

    fun goBack() {
        navController?.popBackStack()
    }
}
