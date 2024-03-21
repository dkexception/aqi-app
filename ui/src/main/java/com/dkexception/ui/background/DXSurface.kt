package com.dkexception.ui.background

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.dkexception.ui.theme.DXColors

/**
 * A primary plane - Surface which serves as a firm, non-transparent background
 * behind any screen / composable
 *
 * @param modifier Modifier used to change the UI appearance
 * @param content Composable content to render
 */
@Composable
fun DXSurface(
    modifier: Modifier = Modifier,
    bgColor: Color = DXColors.screenBackground.primary,
    content: @Composable () -> Unit
) = Surface(
    modifier = modifier,
    color = bgColor
) {
    content()
}

@PreviewLightDark
@Composable
private fun DXSurfacePreview() = DXSurface(
    modifier = Modifier.fillMaxSize()
) {}
