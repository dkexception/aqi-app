package com.dkexception.ui.background

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.dkexception.ui.theme.DXColors

/**
 * A primary plane - Surface which serves as a firm, non-transparent background
 * behind any screen / composable
 *
 * @param modifier Modifier used to change the UI appearance
 * @param paddingValues passed from a Scaffold if this is used in conjunction with a Scaffold
 * @param content Composable content to render
 */
@Composable
fun DXSurface(
    modifier: Modifier = Modifier,
    bgColor: Color = DXColors.screenBackground.primary,
    paddingValues: PaddingValues = PaddingValues(0.dp),
    content: @Composable () -> Unit
) = Surface(
    modifier = modifier.padding(paddingValues),
    color = bgColor
) {
    content()
}

@PreviewLightDark
@Composable
private fun DXSurfacePreview() = DXSurface(
    modifier = Modifier.fillMaxSize(),
    paddingValues = PaddingValues(8.dp),
) {}
