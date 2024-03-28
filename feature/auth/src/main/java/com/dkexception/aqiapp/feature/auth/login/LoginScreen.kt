package com.dkexception.aqiapp.feature.auth.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.dkexception.aqiapp.feature.auth.R
import com.dkexception.ui.buttons.DXPrimaryButton
import com.dkexception.ui.images.DXIllustration
import com.dkexception.ui.scaffold.DXScaffold
import com.dkexception.ui.theme.DXColors
import com.dkexception.ui.theme.DXPaddings
import com.dkexception.ui.theme.headline1
import com.dkexception.ui.theme.regular

@Composable
fun LoginScreen(
    state: LoginScreenState,
    onEvent: (LoginEvent) -> Unit
) = LoginScreenContent(state = state, onEvent = onEvent)

@Composable
private fun LoginScreenContent(
    state: LoginScreenState,
    onEvent: (LoginEvent) -> Unit
) = DXScaffold(
    modifier = Modifier.fillMaxSize(),
    optionalContainerColor = DXColors.screenBackground.secondary
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(DXPaddings.large),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        DXIllustration(
            illustration = R.drawable.ill_login,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
        )

        Spacer(modifier = Modifier.height(DXPaddings.large))

        Text(
            text = "Login",
            style = headline1(),
            color = DXColors.text.dark,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(DXPaddings.small))

        Text(
            text = "Please login to get your local AQI data.",
            style = regular(),
            color = DXColors.text.light,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(DXPaddings.large))

        // TODO login email field

        Spacer(modifier = Modifier.height(DXPaddings.small))

        // TODO login password field

        Spacer(modifier = Modifier.weight(1f))

        DXPrimaryButton(
            text = "Login",
            isEnable = state.isLoginButtonEnabled,
            modifier = Modifier.fillMaxWidth()
        ) {
            onEvent(LoginEvent.OnLoginClicked)
        }

        Spacer(modifier = Modifier.height(DXPaddings.large))
    }
}

@Preview
@Composable
private fun LoginScreenInitPreview() = LoginScreenContent(
    state = LoginScreenState()
) {}

@Preview
@Composable
private fun LoginScreenDataPreview() = LoginScreenContent(
    state = LoginScreenState(
        enteredEmailId = "abc04@getnada.com",
        enteredPassword = "pass@word",
        isLoginButtonEnabled = true
    )
) {}
