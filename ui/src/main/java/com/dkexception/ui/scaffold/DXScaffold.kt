package com.dkexception.ui.scaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * Main reusable Scaffold
 */
@Composable
fun DXScaffold(
    modifier: Modifier,
    optionalTopBar: @Composable () -> Unit = {},
    optionalBottomBar: @Composable () -> Unit = {},
    optionalFloatingActionButton: @Composable () -> Unit = {},
    optionalFloatingActionButtonPosition: FabPosition = FabPosition.End,
    optionalContainerColor: Color = Color.Transparent,
    content: @Composable () -> Unit
) = Scaffold(
    modifier = modifier,
    topBar = optionalTopBar,
    bottomBar = optionalBottomBar,
    containerColor = optionalContainerColor,
    floatingActionButton = optionalFloatingActionButton,
    floatingActionButtonPosition = optionalFloatingActionButtonPosition,
    contentWindowInsets = WindowInsets(0, 0, 0, 0)
) { paddingValues ->

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .consumeWindowInsets(paddingValues)
            .windowInsetsPadding(WindowInsets.safeDrawing)
    ) {
        content()
    }
}
