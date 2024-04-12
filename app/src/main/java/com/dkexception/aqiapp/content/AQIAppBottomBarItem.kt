package com.dkexception.aqiapp.content

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import com.dkexception.ui.theme.DXColors

@Composable
fun RowScope.AQIAppBottomBarItem(
    displayName: String,
    @DrawableRes icon: Int,
    isSelected: Boolean,
    onClicked: () -> Unit
) {

    NavigationBarItem(
        selected = isSelected,
        onClick = {
            if (!isSelected) {
                onClicked()
            }
        },
        icon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = displayName,
                tint = if (isSelected) {
                    DXColors.primary.default
                } else {
                    Color(0xFF6B7280)
                }
            )
        },
        label = {
            Text(
                text = displayName,
                color = if (isSelected) {
                    DXColors.primary.default
                } else {
                    Color(0xFF6B7280)
                },
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = NavigationBarItemDefaults.colors().copy(
            selectedIndicatorColor = DXColors.card.white
        )
    )
}
