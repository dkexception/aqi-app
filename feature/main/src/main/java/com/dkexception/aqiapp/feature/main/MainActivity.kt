package com.dkexception.aqiapp.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dkexception.aqiapp.feature.main.navigation.AppNavHost
import com.dkexception.core.navigation.NavigationManager
import com.dkexception.ui.background.DXSurface
import com.dkexception.ui.system.SetSystemBarColors
import com.dkexception.ui.theme.DXTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationManager: NavigationManager

    private lateinit var mainNavController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            mainNavController = rememberNavController()
            navigationManager.setNavController(mainNavController)

            SetSystemBarColors()

            DXTheme {
                DXSurface(Modifier.fillMaxSize()) {
                    AppNavHost(navController = mainNavController)
                }
            }
        }
    }
}
