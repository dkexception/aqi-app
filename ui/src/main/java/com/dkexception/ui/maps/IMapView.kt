package com.dkexception.ui.maps

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dkexception.ui.maps.data.MapData
import com.dkexception.ui.maps.providers.MapProvider

interface IMapView {

    @Composable
    fun DefaultMapView(
        mapData: MapData,
        modifier: Modifier
    )

    @Composable
    fun MapViewForProvider(
        provider: MapProvider,
        mapData: MapData,
        modifier: Modifier
    )
}
