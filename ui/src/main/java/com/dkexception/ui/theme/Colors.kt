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
        @Composable @ReadOnlyComposable get() = Primary.Default

    val accent: Accent
        @Composable @ReadOnlyComposable get() = Accent.Default

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

    val card: Card
        @Composable @ReadOnlyComposable get() = if (isSystemInDarkTheme()) {
            Card.Dark
        } else {
            Card.Light
        }

    val divider: Divider
        @Composable @ReadOnlyComposable get() = Divider.Default

    val textField: TextField
        @Composable @ReadOnlyComposable get() = if (isSystemInDarkTheme()) {
            TextField.Dark
        } else {
            TextField.Light
        }

    val aqiLevel: AQILevel
        @Composable @ReadOnlyComposable get() = AQILevel.Default
}

sealed class Primary(
    val default: Color,
    val light: Color,
    val dark: Color
) {

    data object Default : Primary(
        default = Color(0xFF1882FF),
        light = Color(0xFFE3F2FF),
        dark = Color(0xFF245DD8)
    )
}

sealed class Accent(
    val default: Color,
    val light: Color,
    val dark: Color
) {

    data object Default : Accent(
        default = Color(0xFF00CD85),
        light = Color(0xFFBDEDD4),
        dark = Color(0xFF00A056)
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

sealed class Card(
    val white: Color,
    val gray: Color,
    val shadowColor: Color
) {

    data object Light : Card(
        white = Color(0xFFFFFFFF),
        gray = Color(0xFFF5F5F5),
        shadowColor = Color(0xFFFFFFFF)
    )

    data object Dark : Card(
        white = Color(0xFF262626),
        gray = Color(0xFF121212),
        shadowColor = Color(0xFF1C1C1C)
    )
}

sealed class Divider(
    val default: Color
) {

    data object Default : Divider(
        default = Color(0xFFF3F4F6)
    )
}

sealed class TextField(
    val focusedText: Color,
    val focusedBorder: Color,
    val unfocusedBorder: Color,
    val error: Color,
    val container: Color,
    val placeholder: Color,
    val cursor: Color,
    val selectionHandle: Color
) {

    data object Light : TextField(
        focusedText = Color(0xFF1C1C1E),
        focusedBorder = Primary.Default.default,
        unfocusedBorder = Color(0xFFE4E4E4),
        error = Color(0xFFF54251),
        container = Color.White,
        placeholder = Color(0xFF848485),
        cursor = Primary.Default.default,
        selectionHandle = Primary.Default.default
    )

    data object Dark : TextField(
        focusedText = Color(0xFFF5F5F5),
        focusedBorder = Primary.Default.default,
        unfocusedBorder = Color(0xFFE4E4E4),
        error = Color(0xFFD90000),
        container = Color(0xFF262626),
        placeholder = Color(0xFF848485),
        cursor = Primary.Default.default,
        selectionHandle = Primary.Default.default
    )
}

sealed class AQILevel(
    val good: Color,
    val moderate: Color,
    val bad: Color,
    val poor: Color,
    val unhealthy: Color,
    val hazardous: Color,
    val unknown: Color,
) {

    data object Default : AQILevel(
        good = Color(0xFFCCFFCC),
        moderate = Color(0xFFE0F8E0),
        bad = Color(0xFFFFDAB9),
        poor = Color(0xFFFFA07A),
        unhealthy = Color(0xFFE6E6FA),
        hazardous = Color(0xFFFFCCCC),
        unknown = Color.White
    )
}
