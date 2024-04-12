package com.dkexception.ui.maps.providers

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.dkexception.ui.R
import com.dkexception.ui.maps.data.MapData
import com.mappls.sdk.maps.MapView
import com.mappls.sdk.maps.MapplsMap
import com.mappls.sdk.maps.OnMapReadyCallback
import com.mappls.sdk.maps.camera.CameraPosition
import com.mappls.sdk.maps.geometry.LatLng

@SuppressLint("InflateParams")
@Composable
internal fun MapMyIndiaMapView(
    mapData: MapData,
    modifier: Modifier = Modifier
) {

    AndroidView(
        modifier = modifier,
        factory = { context ->
            LayoutInflater.from(context).inflate(R.layout.mmi_map_view, null, false).apply {

                val mapView = findViewById<MapView>(R.id.mmi_map)

                val cameraPosition: CameraPosition = CameraPosition.Builder()
                    .target(LatLng(mapData.focusedLat ?: 0.0, mapData.focusedLng ?: 0.0))
                    .zoom(mapData.zoomLevel?.toDouble() ?: 10.0)
                    .build()

                mapView.getMapAsync(
                    object : OnMapReadyCallback {

                        override fun onMapReady(p0: MapplsMap) {
                            p0.cameraPosition = cameraPosition
                            p0.uiSettings?.let {
                                it.isScrollGesturesEnabled = mapData.allowScrolling
                                it.isRotateGesturesEnabled = mapData.allowScrolling
                            }
                        }

                        override fun onMapError(p0: Int, p1: String?) {
                            Toast.makeText(context, "Map Error - $p1", Toast.LENGTH_SHORT).show()
                        }
                    }
                )
            }
        }
    )
}
