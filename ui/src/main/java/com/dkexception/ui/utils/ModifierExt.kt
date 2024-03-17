package com.dkexception.ui.utils

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.focused
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId

var packageIdName: String? = "com.dkexception.aqiapp"

/**
 * Modifier ext to add Semantic property [SemanticsPropertyReceiver.contentDescription]
 * for description of the semantics node. This will help TalkBack or Accessibility app
 * to increase app component access and reading.
 *
 * @param content : Content to be announce like : Double tab to "[content]"
 * @return [Modifier]
 */
@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.semanticModifier(
    content: String? = null,
    onClickLabel: String? = null,
    layoutId: String? = null,
    enabled: Boolean = true,
    isClickable: Boolean = true,
    isFocused: Boolean = false,
    role: Role? = null
) = this
    .then(
        layoutId?.let {
            Modifier
                .semantics {
                    this.testTagsAsResourceId = true
                }
                .testTag("$packageIdName:id/$it")
                .layoutId("$packageIdName:id/$it")
        } ?: kotlin.run {
            Modifier
        }
    )
    .then(
        content?.let {
            clearAndSetSemantics {
                contentDescription = content
                if (!enabled) {
                    disabled()
                }
                if (role != null) {
                    this.role = role
                }
                if (isFocused) {
                    focused = isFocused
                }
                if (isClickable)
                    this.onClick(onClickLabel ?: content, null)
                this.testTagsAsResourceId = true
            }
        } ?: kotlin.run {
            Modifier.semantics {
                this.testTagsAsResourceId = true
            }
        }
    )
