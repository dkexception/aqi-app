package com.dkexception.ui.system

import android.graphics.Color
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.dkexception.ui.theme.DXColors

/**
 * Sets the relevant foreground color to the system bars i.e. Status & Navigation bars
 * This means, dark icons in light theme & light icons in dark theme
 */
@Composable
fun ComponentActivity.SetSystemBarColors() {

    val isSystemInDarkTheme = isSystemInDarkTheme()

    DisposableEffect(isSystemInDarkTheme) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                Color.TRANSPARENT,
                Color.TRANSPARENT,
            ) { isSystemInDarkTheme },
            navigationBarStyle = SystemBarStyle.auto(
                DXColors.lightScrim,
                DXColors.darkScrim,
            ) { isSystemInDarkTheme },
        )
        onDispose {}
    }
}
