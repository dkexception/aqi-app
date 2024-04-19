package com.dkexception.ui.maps.providers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.dkexception.ui.maps.data.MapData
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

@Composable
internal fun GoogleMapView(
    mapData: MapData,
    modifier: Modifier = Modifier
) {

    val positionToFocus = LatLng(mapData.focusedLat ?: 0.0, mapData.focusedLng ?: 0.0)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(positionToFocus, mapData.zoomLevel ?: 10f)
    }

    val mapProperties by remember {
        mutableStateOf(
            MapProperties()
        )
    }

    val mapUiSettings by remember {
        mutableStateOf(
            MapUiSettings(
                mapToolbarEnabled = false,
                myLocationButtonEnabled = true,
                rotationGesturesEnabled = mapData.allowScrolling,
                scrollGesturesEnabled = mapData.allowScrolling,
                zoomControlsEnabled = mapData.allowScrolling,
                zoomGesturesEnabled = mapData.allowScrolling
            )
        )
    }

    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraPositionState,
        properties = mapProperties,
        uiSettings = mapUiSettings,
        onMapClick = {
            mapData.onMapClicked()
        }
    ) {

        Marker(
            state = rememberMarkerState(position = positionToFocus),
            icon = BitmapDescriptorFactory.defaultMarker(219.428f)
        )
    }
}
