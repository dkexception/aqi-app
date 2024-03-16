package com.dkexception.core.model

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

/**
 * A common text wrapper for all strings in & out
 */
sealed class UIText {

    companion object {

        val DEFAULT_ERROR_TEXT = UIText.DynamicString("Error")
    }

    data class DynamicString(val value: String) : UIText()

    class StringResource(
        @StringRes val resId: Int,
        vararg val args: Any
    ) : UIText()

    @Composable
    fun asString(): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> stringResource(resId, *args)
        }
    }

    fun asString(context: Context): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> context.getString(resId, *args)
        }
    }
}

fun String.toUIText(): UIText = UIText.DynamicString(this)
