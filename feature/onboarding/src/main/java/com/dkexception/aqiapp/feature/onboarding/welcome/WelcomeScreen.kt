package com.dkexception.aqiapp.feature.onboarding.welcome

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dkexception.aqiapp.feature.onboarding.R
import com.dkexception.ui.images.DXIllustration

@Composable
fun WelcomeScreen() = Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
) {
    DXIllustration(
        illustration = R.drawable.ill_welcome_bg,
        modifier = Modifier.fillMaxSize()
    )
}

@Preview
@Composable
private fun WelcomeScreenPreview() = WelcomeScreen()
