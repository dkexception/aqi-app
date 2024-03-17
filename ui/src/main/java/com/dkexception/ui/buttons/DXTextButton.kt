package com.dkexception.ui.buttons

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.dkexception.ui.theme.DXColors
import com.dkexception.ui.theme.button
import com.dkexception.ui.utils.semanticModifier

/**
 * A secondary text button for non-primary actions
 *
 * @param text text on the button
 * @param modifier modifier to change the UI appearance
 * @param isEnable used to turn the button disabled
 * @param onClickAction action to perform on the button click
 */
@Composable
fun DXTextButton(
    text: String,
    modifier: Modifier = Modifier,
    isEnable: Boolean = true,
    layoutId: String? = null,
    contentDescription: String? = null,
    onClickAction: () -> Unit
) = TextButton(
    onClick = onClickAction,
    enabled = isEnable,
    modifier = modifier.semanticModifier(
        contentDescription ?: text,
        enabled = isEnable,
        role = Role.Button,
        layoutId = layoutId
    ),
    colors = ButtonDefaults.textButtonColors(
        contentColor = DXColors.text.light,
        disabledContentColor = DXColors.text.disabled
    )
) {
    Text(
        text = text,
        style = button()
    )
}

@Preview
@Composable
private fun DXTextButtonEnabledPreview() = DXTextButton(
    text = "Skip"
) {}

@Preview
@Composable
private fun DXTextButtonDisabledPreview() = DXTextButton(
    text = "Skip",
    isEnable = false
) {}
