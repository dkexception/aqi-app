package com.dkexception.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

object DXColors {

    /**
     * The default light scrim, as defined by androidx and the platform:
     * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:activity/activity/src/main/java/androidx/activity/EdgeToEdge.kt;l=35-38;drc=27e7d52e8604a080133e8b842db10c89b4482598
     */
    val lightScrim = android.graphics.Color.argb(0xe6, 0xFF, 0xFF, 0xFF)

    /**
     * The default dark scrim, as defined by androidx and the platform:
     * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:activity/activity/src/main/java/androidx/activity/EdgeToEdge.kt;l=40-44;drc=27e7d52e8604a080133e8b842db10c89b4482598
     */
    val darkScrim = android.graphics.Color.argb(0x80, 0x1b, 0x1b, 0x1b)

    val primary: Primary
        @Composable @ReadOnlyComposable get() = if (isSystemInDarkTheme()) {
            Primary.Dark
        } else {
            Primary.Light
        }

    val text: Text
        @Composable @ReadOnlyComposable get() = if (isSystemInDarkTheme()) {
            Text.Dark
        } else {
            Text.Light
        }

    val screenBackground: ScreenBackground
        @Composable @ReadOnlyComposable get() = if (isSystemInDarkTheme()) {
            ScreenBackground.Dark
        } else {
            ScreenBackground.Light
        }
}

sealed class Primary(
    val default: Color,
    val light: Color,
    val dark: Color
) {

    data object Light : Primary(
        default = Color(0xFF1882FF),
        light = Color(0xFFE3F2FF),
        dark = Color(0xFF245DD8)
    )

    data object Dark : Primary(
        default = Color(0xFF1882FF),
        light = Color(0xFFE3F2FF),
        dark = Color(0xFF245DD8)
    )
}

sealed class Text(
    val dark: Color,
    val light: Color,
    val disabled: Color
) {

    data object Light : Text(
        dark = Color(0xFF1C1C1E),
        light = Color(0xFF5C5C5D),
        disabled = Color(0xFFA4A4A5)
    )

    data object Dark : Text(
        dark = Color(0xFFF5F5F5),
        light = Color(0xFFCCCCCC),
        disabled = Color(0xFF414141),
    )
}

sealed class ScreenBackground(
    val primary: Color,
    val secondary: Color
) {

    data object Light : ScreenBackground(
        primary = Color.White,
        secondary = Color(0xFFFAFAFA)
    )

    data object Dark : ScreenBackground(
        primary = Color(0xFF000000),
        secondary = Color(0XFF121212)
    )
}
