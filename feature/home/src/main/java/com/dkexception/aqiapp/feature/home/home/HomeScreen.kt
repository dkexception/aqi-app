package com.dkexception.aqiapp.feature.home.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dkexception.aqiapp.feature.aqidetails.contract.IAQIDetailsCard
import com.dkexception.aqiapp.feature.aqisdk.model.AirQualityData
import com.dkexception.ui.indicators.DXPullToRefreshContainer
import com.dkexception.ui.scaffold.DXScaffold
import com.dkexception.ui.theme.DXColors
import com.dkexception.ui.theme.DXPaddings
import com.dkexception.ui.theme.headline1
import com.dkexception.ui.theme.large
import com.dkexception.ui.theme.regular

@Composable
fun HomeScreen(
    state: HomeScreenState,
    aqiIAQIDetailsCard: IAQIDetailsCard,
    onEvent: (HomeEvent) -> Unit
) = HomeScreenContent(
    state = state,
    aqiIAQIDetailsCard = aqiIAQIDetailsCard,
    onEvent = onEvent
)

@Composable
private fun HomeScreenContent(
    state: HomeScreenState,
    aqiIAQIDetailsCard: IAQIDetailsCard,
    onEvent: (HomeEvent) -> Unit
) = DXScaffold(modifier = Modifier.fillMaxSize()) {

    DXPullToRefreshContainer(
        modifier = Modifier.fillMaxSize(),
        isRefreshing = state.isLoading,
        onPulled = {
            onEvent(HomeEvent.OnPulledToRefresh)
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(DXPaddings.default)
        ) {

            item {
                Text(
                    text = "Welcome \uD83D\uDC4B",
                    style = regular(),
                    color = DXColors.text.light,
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.height(DXPaddings.small))

                Text(
                    text = state.userName,
                    style = headline1(),
                    color = DXColors.text.dark,
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.height(DXPaddings.xLarge))
            }

            item {
                if (!state.isLoading && state.aqiData != null) {
                    Text(
                        text = "AQI data near you",
                        style = large(),
                        color = DXColors.text.dark,
                        textAlign = TextAlign.Start
                    )
                    Spacer(modifier = Modifier.height(DXPaddings.small))
                    aqiIAQIDetailsCard.AQIDetailsCard(
                        aqiData = state.aqiData
                    ) {
                        onEvent(HomeEvent.OnAQICardClicked)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() = HomeScreen(
    state = HomeScreenState(
        userName = "Dhanesh",
        aqiData = AirQualityData(),
        isLoading = false
    ),
    aqiIAQIDetailsCard = { _, _ ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Cyan)
        )
    }
) {}
