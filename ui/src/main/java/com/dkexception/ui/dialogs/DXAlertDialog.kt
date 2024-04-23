package com.dkexception.ui.dialogs

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DXAlertDialog(
    title: String,
    optionalSubtitle: String? = null,
    primaryButtonTextToActionPair: Pair<String, () -> Unit>,
    optionalSecondaryButtonTextToActionPair: Pair<String, () -> Unit>? = null,
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        title = {
            Text(text = title)
        },
        text = optionalSubtitle?.let {
            {
                Text(text = it)
            }
        },
        confirmButton = {
            TextButton(onClick = primaryButtonTextToActionPair.second) {
                Text(text = primaryButtonTextToActionPair.first)
            }
        },
        dismissButton = optionalSecondaryButtonTextToActionPair?.let {
            {
                TextButton(onClick = it.second) {
                    Text(text = it.first)
                }
            }
        },
        onDismissRequest = onDismissRequest
    )
}

@Preview
@Composable
private fun DXAlertDialogPreview() = DXAlertDialog(
    title = "Are you sure?",
    optionalSubtitle = "Logging out will clear your saved places and all data.",
    primaryButtonTextToActionPair = "Log Out" to {},
    optionalSecondaryButtonTextToActionPair = "Cancel" to {}
) {}
