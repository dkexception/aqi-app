package com.dkexception.ui.buttons

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dkexception.ui.theme.DXColors
import com.dkexception.ui.theme.DXPaddings
import com.dkexception.ui.theme.button
import com.dkexception.ui.utils.semanticModifier

/**
 * A primary filled button to take confirmation
 *
 * @param text text on the button
 * @param modifier modifier to change the UI appearance
 * @param isEnable used to turn the button disabled
 * @param onClickAction action to perform on the button click
 */
@Composable
fun DXPrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    isEnable: Boolean = true,
    layoutId: String? = null,
    contentDescription: String? = null,
    onClickAction: () -> Unit
) = ElevatedButton(
    onClick = onClickAction,
    enabled = isEnable,
    modifier = modifier
        .semanticModifier(
            contentDescription ?: text,
            enabled = isEnable,
            role = Role.Button,
            layoutId = layoutId
        ),
    shape = RoundedCornerShape(12.dp),
    colors = ButtonDefaults.elevatedButtonColors(
        containerColor = DXColors.primary.default,
        contentColor = Color.White,
        disabledContainerColor = DXColors.primary.light,
        disabledContentColor = DXColors.text.disabled
    )
) {
    Text(
        text = text,
        style = button(),
        modifier = Modifier
            .padding(DXPaddings.small)
            .align(Alignment.CenterVertically)
    )
}

@Preview
@Composable
private fun DXPrimaryButtonEnabledPreview() = DXPrimaryButton(text = "Get Started") {}

@Preview
@Composable
private fun DXPrimaryButtonDisabledPreview() = DXPrimaryButton(
    text = "Get Started",
    isEnable = false
) {}
