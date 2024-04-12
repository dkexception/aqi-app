package com.dkexception.ui.indicators

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dkexception.ui.theme.DXColors

/**
 * The circular progress indicator in Primary color
 */
@Composable
fun DXCircularProgressIndicator(
    modifier: Modifier = Modifier
) = CircularProgressIndicator(
    modifier = modifier,
    color = DXColors.primary.default
)

@Preview
@Composable
private fun DXCircularProgressIndicatorPreview() = DXCircularProgressIndicator()
