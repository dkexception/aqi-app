package com.dkexception.aqiapp.feature.aqidetails.details

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AQIDetailsScreen(
    state: AQIDetailsScreenState,
    onEvent: (AQIDetailsEvent) -> Unit
) {
    AQIDetailsScreenContent(state = state, onEvent = onEvent)
}

@Composable
private fun AQIDetailsScreenContent(
    state: AQIDetailsScreenState,
    onEvent: (AQIDetailsEvent) -> Unit
) {

}

@Preview
@Composable
private fun AQIDetailsScreenPreview() = AQIDetailsScreen(
    state = AQIDetailsScreenState()
) { }
