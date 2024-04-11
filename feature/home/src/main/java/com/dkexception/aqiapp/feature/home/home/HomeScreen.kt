package com.dkexception.aqiapp.feature.home.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.dkexception.ui.maps.IMapView
import com.dkexception.ui.maps.data.MapData
import com.dkexception.ui.maps.providers.MapProvider
import com.dkexception.ui.scaffold.DXScaffold
import com.dkexception.ui.theme.DXPaddings

@Composable
fun HomeScreen(
    state: HomeScreenState,
    mMapView: IMapView,
    onEvent: (HomeEvent) -> Unit
) = HomeScreenContent(
    state = state,
    mMapView = mMapView,
    onEvent = onEvent
)

@Composable
private fun HomeScreenContent(
    state: HomeScreenState,
    mMapView: IMapView,
    onEvent: (HomeEvent) -> Unit
) = DXScaffold(modifier = Modifier.fillMaxSize()) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(DXPaddings.small)
    ) {
        mMapView.MapViewForProvider(
            provider = MapProvider.GOOGLE,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            mapData = MapData(
                focusedLat = 1.35, // Singapore
                focusedLng = 103.87,
                zoomLevel = 10f
            )
        )
        mMapView.MapViewForProvider(
            provider = MapProvider.MAP_MY_INDIA,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            mapData = MapData(
                focusedLat = 1.35, // Singapore
                focusedLng = 103.87,
                zoomLevel = 10f
            )
        )
        mMapView.MapViewForProvider(
            provider = MapProvider.OPEN_STREET_MAP,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            mapData = MapData(
                focusedLat = 1.35, // Singapore
                focusedLng = 103.87,
                zoomLevel = 10f
            )
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() = HomeScreen(
    state = HomeScreenState(),
    mMapView = object : IMapView {

        @Composable
        override fun DefaultMapView(
            mapData: MapData,
            modifier: Modifier
        ) = Box(
            modifier = modifier.background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Map View")
        }

        @Composable
        override fun MapViewForProvider(
            provider: MapProvider,
            mapData: MapData,
            modifier: Modifier
        ) = Box(
            modifier = modifier.background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Map View")
        }
    }
) {}
