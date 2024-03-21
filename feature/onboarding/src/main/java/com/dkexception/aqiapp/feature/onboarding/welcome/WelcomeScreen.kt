package com.dkexception.aqiapp.feature.onboarding.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.dkexception.aqiapp.feature.onboarding.R
import com.dkexception.ui.images.DXIllustration
import com.dkexception.ui.theme.DXColors

@Composable
fun WelcomeScreen() = Box(
    modifier = Modifier
        .fillMaxSize()
        .background(DXColors.screenBackground.secondary),
    contentAlignment = Alignment.Center
) {
    DXIllustration(
        illustration = R.drawable.ill_welcome_bg,
        modifier = Modifier.fillMaxSize(),
        optionalContentScale = ContentScale.FillBounds
    )
}

@Preview
@Composable
private fun WelcomeScreenPreview() = WelcomeScreen()
