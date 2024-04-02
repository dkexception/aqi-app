package com.dkexception.aqiapp.feature.dashboard.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
) {
    DXScaffold(modifier = Modifier.fillMaxSize()) {
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
}
