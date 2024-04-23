package com.dkexception.aqiapp.feature.more.list

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dkexception.aqiapp.feature.more.R
import com.dkexception.core.model.UIText
import com.dkexception.ui.cards.DXCard
import com.dkexception.ui.dialogs.DXAlertDialog
import com.dkexception.ui.dividers.DXDivider
import com.dkexception.ui.images.DXIllustration
import com.dkexception.ui.theme.DXColors
import com.dkexception.ui.theme.DXPaddings
import com.dkexception.ui.theme.headline2
import com.dkexception.ui.theme.regular
import com.dkexception.ui.R.drawable as UIDrawables

@Composable
fun MoreListScreen(
    state: MoreListScreenState,
    onEvent: (MoreListEvent) -> Unit
) = MoreListScreenContent(state = state, onEvent = onEvent)

@Composable
private fun MoreListScreenContent(
    state: MoreListScreenState,
    onEvent: (MoreListEvent) -> Unit
) {

    if (state.isConfirmLogoutPopupVisible) {
        DXAlertDialog(
            title = "Log out?",
            optionalSubtitle = "Logging out from the app will clear all your saved locations and data.",
            primaryButtonTextToActionPair = "Confirm" to {
                onEvent(MoreListEvent.OnConfirmLogoutPopupAction(true))
            },
            optionalSecondaryButtonTextToActionPair = "Cancel" to {
                onEvent(MoreListEvent.OnConfirmLogoutPopupAction(false))
            }
        ) { }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DXColors.screenBackground.secondary),
        contentAlignment = Alignment.Center
    ) {

        DXIllustration(
            illustration = R.drawable.ill_more_bg,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            optionalContentScale = ContentScale.FillWidth
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding(),
            contentPadding = PaddingValues(
                top = LocalConfiguration.current.screenHeightDp.dp * .13f,
                end = DXPaddings.large,
                bottom = DXPaddings.large,
                start = DXPaddings.large
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(DXColors.accent.light),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = UIDrawables.app_icon),
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
            }

            item {
                Text(
                    text = state.userName,
                    color = DXColors.text.dark,
                    style = headline2()
                )

                Spacer(modifier = Modifier.height(DXPaddings.small))

                Text(
                    text = state.emailId,
                    color = DXColors.text.light,
                    style = regular()
                )

                Spacer(modifier = Modifier.height(DXPaddings.default))

                DXDivider(Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(DXPaddings.default))
            }

            items(
                listOf(
                    Triple(
                        UIDrawables.ic_profile,
                        UIText.DynamicString("Profile"),
                        MoreListItem.PROFILE
                    ),
                    Triple(
                        UIDrawables.ic_location,
                        UIText.DynamicString("Saved Locations"),
                        MoreListItem.SAVED_LOCATIONS
                    ),
                    Triple(UIDrawables.ic_faq, UIText.DynamicString("FAQ"), MoreListItem.FAQ)
                )
            ) {

                MoreItemRow(
                    icon = it.first,
                    name = it.second
                ) {
                    onEvent(MoreListEvent.OnItemClicked(it.third))
                }

                Spacer(modifier = Modifier.height(DXPaddings.small))
            }

            item {
                Spacer(modifier = Modifier.height(DXPaddings.default))

                DXDivider(Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(DXPaddings.default))
            }

            items(
                listOf(
                    Triple(
                        UIDrawables.ic_settings,
                        UIText.DynamicString("Settings"),
                        MoreListItem.SETTINGS
                    ),
                    Triple(
                        UIDrawables.ic_about_us,
                        UIText.DynamicString("About Us"),
                        MoreListItem.ABOUT_US
                    ),
                    Triple(
                        UIDrawables.ic_contact_us,
                        UIText.DynamicString("Contact Us"),
                        MoreListItem.CONTACT_US
                    ),
                    Triple(
                        UIDrawables.ic_logout,
                        UIText.DynamicString("Logout"),
                        MoreListItem.LOGOUT
                    )
                )
            ) {

                MoreItemRow(
                    icon = it.first,
                    name = it.second
                ) {
                    onEvent(MoreListEvent.OnItemClicked(it.third))
                }

                Spacer(modifier = Modifier.height(DXPaddings.small))
            }

            item {
                Spacer(modifier = Modifier.height(DXPaddings.default))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = state.appName,
                        style = headline2(),
                        color = DXColors.text.dark
                    )

                    Spacer(modifier = Modifier.height(DXPaddings.small))

                    Text(
                        text = "App Version ${state.appVersion}",
                        style = regular(),
                        color = DXColors.text.light
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(DXPaddings.default))
    }
}

@Composable
private fun MoreItemRow(
    @DrawableRes icon: Int,
    name: UIText,
    onClickAction: () -> Unit
) = DXCard(
    modifier = Modifier.fillMaxWidth(),
    onClickAction = onClickAction
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = DXPaddings.default,
                vertical = DXPaddings.default
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = DXColors.primary.dark
        )

        Spacer(modifier = Modifier.width(DXPaddings.default))

        Text(
            text = name.asString(LocalContext.current),
            style = regular().copy(
                lineHeight = 24.sp
            ),
            color = DXColors.text.dark
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            painter = painterResource(id = UIDrawables.ic_chevron_right),
            contentDescription = null,
            tint = DXColors.primary.dark
        )
    }
}

@Preview
@Composable
private fun MoreListScreenPreview() = MoreListScreen(
    state = MoreListScreenState(
        userName = "Dhanesh Katre",
        emailId = "dkexception@gmail.com",
        appName = "AQI App",
        appVersion = "1.0"
    )
) { }

@Preview
@Composable
private fun MoreListScreenLogoutPreview() = MoreListScreen(
    state = MoreListScreenState(
        userName = "Dhanesh Katre",
        emailId = "dkexception@gmail.com",
        appName = "AQI App",
        appVersion = "1.0",
        isConfirmLogoutPopupVisible = true
    )
) { }
