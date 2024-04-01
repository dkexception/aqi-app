package com.dkexception.ui.dividers

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dkexception.ui.theme.DXColors

@Composable
fun DXDivider(
    modifier: Modifier = Modifier,
    optionalDividerColor: Color? = null
) = HorizontalDivider(
    modifier = modifier,
    thickness = 1.dp,
    color = optionalDividerColor ?: DXColors.divider.default
)

@Preview
@Composable
private fun DXDividerPreview() = DXDivider(
    modifier = Modifier.fillMaxWidth(),
    optionalDividerColor = Color.Red
)
