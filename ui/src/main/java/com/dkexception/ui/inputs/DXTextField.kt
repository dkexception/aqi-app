package com.dkexception.ui.inputs

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dkexception.ui.R
import com.dkexception.ui.theme.DXColors
import com.dkexception.ui.theme.regular
import com.dkexception.ui.theme.textField
import com.dkexception.ui.theme.textFieldPlaceholder

@Composable
fun DXTextField(
    text: String,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    isReadOnly: Boolean = false,
    isError: Boolean = false,
    isSingleLine: Boolean = false,
    isPasswordField: Boolean = false,
    optionalSupportingText: String? = null,
    optionalPlaceholderText: String? = null,
    @DrawableRes optionalLeadingIcon: Int? = null,
    @DrawableRes optionalTrailingIcon: Int? = null,
    optionalKeyboardOptions: KeyboardOptions? = null,
    optionalKeyboardActions: KeyboardActions? = null,
    onChange: (String) -> Unit
) {

    var isPasswordVisible: Boolean by rememberSaveable {
        mutableStateOf(false)
    }

    val trailingIcon: (@Composable () -> Unit)? = if (isPasswordField) {
        {
            IconButton(
                onClick = {
                    isPasswordVisible = !isPasswordVisible
                }
            ) {
                Icon(
                    painter = painterResource(id = optionalTrailingIcon ?: R.drawable.ic_eye),
                    contentDescription = null
                )
            }
        }
    } else if (optionalTrailingIcon != null) {
        {
            Icon(
                painter = painterResource(id = optionalTrailingIcon),
                contentDescription = null
            )
        }
    } else {
        null
    }

    OutlinedTextField(
        value = text,
        isError = isError,
        modifier = modifier,
        enabled = isEnabled,
        readOnly = isReadOnly,
        textStyle = textField(),
        onValueChange = onChange,
        singleLine = isSingleLine,
        shape = RoundedCornerShape(8.dp),
        keyboardOptions = optionalKeyboardOptions ?: KeyboardOptions.Default,
        keyboardActions = optionalKeyboardActions ?: KeyboardActions.Default,
        leadingIcon = optionalLeadingIcon?.let {
            {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = null
                )
            }
        },
        trailingIcon = trailingIcon,
        placeholder = optionalPlaceholderText?.let {
            {
                Text(
                    text = it,
                    style = textFieldPlaceholder()
                )
            }
        },
        supportingText = optionalSupportingText?.let {
            {
                Text(
                    text = it,
                    style = regular()
                )
            }
        },
        visualTransformation = when {
            isPasswordField -> if (isPasswordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }

            else -> VisualTransformation.None
        },
        colors = OutlinedTextFieldDefaults.colors(

            focusedTextColor = DXColors.textField.focusedText,
            unfocusedTextColor = DXColors.textField.focusedText,
            errorTextColor = DXColors.textField.error,

            focusedBorderColor = DXColors.textField.focusedBorder,
            unfocusedBorderColor = DXColors.textField.unfocusedBorder,
            errorBorderColor = DXColors.textField.error,

            focusedContainerColor = DXColors.textField.container,
            unfocusedContainerColor = DXColors.textField.container,
            errorContainerColor = DXColors.textField.container,
            disabledContainerColor = DXColors.textField.container,

            focusedLeadingIconColor = DXColors.textField.placeholder,
            unfocusedLeadingIconColor = DXColors.textField.placeholder,
            errorLeadingIconColor = DXColors.textField.error,

            focusedTrailingIconColor = DXColors.textField.placeholder,
            unfocusedTrailingIconColor = DXColors.textField.placeholder,
            errorTrailingIconColor = DXColors.textField.error,

            focusedSupportingTextColor = DXColors.textField.placeholder,
            unfocusedSupportingTextColor = DXColors.textField.placeholder,
            errorSupportingTextColor = DXColors.textField.error,

            focusedPlaceholderColor = DXColors.textField.placeholder,
            unfocusedPlaceholderColor = DXColors.textField.placeholder,
            errorPlaceholderColor = DXColors.textField.error,

            cursorColor = DXColors.textField.cursor,
            errorCursorColor = DXColors.textField.error,
            selectionColors = TextSelectionColors(
                handleColor = DXColors.textField.selectionHandle,
                backgroundColor = DXColors.textField.selectionHandle.copy(alpha = .4f)
            )
        )
    )
}

@Preview
@Composable
private fun DXTextFieldEmptyPreview() = DXTextField(
    text = "",
    optionalPlaceholderText = "Your name here",
    optionalTrailingIcon = R.drawable.ic_account,
    modifier = Modifier.fillMaxWidth()
) {}

@Preview
@Composable
private fun DXTextFieldWithTextPreview() = DXTextField(
    text = "dkexception@gmail.com",
    optionalPlaceholderText = "Your email here",
    modifier = Modifier.fillMaxWidth(),
    optionalLeadingIcon = R.drawable.ic_mail
) {}

@Preview
@Composable
private fun DXTextFieldWithErrorTextPreview() = DXTextField(
    text = "dkexception@gmail",
    optionalPlaceholderText = "Enter your email",
    modifier = Modifier.fillMaxWidth(),
    optionalLeadingIcon = R.drawable.ic_key,
    isError = true,
    optionalSupportingText = "Please enter a valid email!"
) {}
