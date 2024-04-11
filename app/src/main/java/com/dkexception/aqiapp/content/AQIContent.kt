package com.dkexception.aqiapp.content

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dkexception.aqiapp.navigation.AQIAppNavHost
import com.dkexception.core.navigation.NavRoute

@Composable
fun AQIContent(
    controller: NavHostController
) = Scaffold(
    modifier = Modifier.fillMaxSize(),
    containerColor = Color.Transparent,
    contentWindowInsets = WindowInsets(0, 0, 0, 0),
    bottomBar = {

        val isBottomNavRoute: Boolean = controller.isBottomNavRoute()

        AQIAppBottomBar(
            isBottomBarVisible = isBottomNavRoute,
            isTabSelected = {
                controller.isTabSelected(route = it)
            },
            onTabClicked = {
                controller.navigate(it) {

                    popUpTo(NavRoute.HOME.ROOT) {
                        saveState = true
                    }

                    launchSingleTop = true

                    restoreState = true
                }
            }
        )
    }
) {
    AQIAppNavHost(
        navController = controller,
        modifier = Modifier
            .fillMaxSize()
            .padding(it)
    )
}

@Composable
private fun NavController.isBottomNavRoute(): Boolean {

    val navBackStackEntry by currentBackStackEntryAsState()

    val currentDestination = navBackStackEntry?.destination

    val currentNavRoute = currentDestination?.route

    return currentNavRoute in listOf(
        NavRoute.HOME.ROOT,
        NavRoute.DATABANK.MAIN,
        NavRoute.MORE.LIST
    )
}

@Composable
private fun NavController.isTabSelected(route: String): Boolean {

    val navBackStackEntry = this.currentBackStackEntry

    val currentDestination = navBackStackEntry?.destination

    return currentDestination?.hierarchy?.any {

        val routeArr = it.route?.split("?") ?: emptyList()
        val authority = if (routeArr.isEmpty()) {
            it.route
        } else {
            routeArr[0]
        }
        authority?.let { schema -> route.startsWith(schema) } == true
    } ?: false
}
