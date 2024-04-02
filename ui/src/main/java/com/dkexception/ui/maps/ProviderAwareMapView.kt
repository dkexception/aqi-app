package com.dkexception.ui.maps

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dkexception.ui.maps.data.MapData
import com.dkexception.ui.maps.providers.GoogleMapView
import com.dkexception.ui.maps.providers.MapMyIndiaMapView
import com.dkexception.ui.maps.providers.MapProvider
import com.dkexception.ui.maps.providers.OpenStreetMapView
import javax.inject.Inject

internal class ProviderAwareMapView @Inject constructor() : IMapView {

    @Composable
    override fun DefaultMapView(
        mapData: MapData,
        modifier: Modifier,
    ) = MapViewByProvider(
        provider = MapProvider.getDefault(),
        mapData = mapData,
        modifier = modifier
    )

    @Composable
    override fun MapViewForProvider(
        provider: MapProvider,
        mapData: MapData,
        modifier: Modifier
    ) = MapViewByProvider(provider = provider, mapData = mapData, modifier = modifier)

    @Composable
    private fun MapViewByProvider(
        provider: MapProvider,
        mapData: MapData,
        modifier: Modifier
    ) = when (provider) {
        MapProvider.GOOGLE -> GoogleMapView(
            mapData = mapData,
            modifier = modifier
        )

        MapProvider.OPEN_STREET_MAP -> OpenStreetMapView(
            mapData = mapData,
            modifier = modifier
        )

        MapProvider.MAP_MY_INDIA -> MapMyIndiaMapView(
            mapData = mapData,
            modifier = modifier
        )
    }
}
