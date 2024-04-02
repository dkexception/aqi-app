package com.dkexception.ui.maps.providers

import android.annotation.SuppressLint
import android.graphics.Rect
import android.view.LayoutInflater
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.dkexception.ui.R
import com.dkexception.ui.maps.data.MapData
import com.dkexception.ui.utils.getOSMSharedPrefs
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

@SuppressLint("InflateParams")
@Composable
internal fun OpenStreetMapView(
    mapData: MapData,
    modifier: Modifier = Modifier
) {

    AndroidView(
        modifier = modifier,
        factory = {
            LayoutInflater.from(it).inflate(R.layout.osm_map_view, null, false).apply {

                val mapView = findViewById<MapView>(R.id.osm_map)
                mapView.setTileSource(TileSourceFactory.MAPNIK)

                Configuration.getInstance().load(
                    it,
                    it.getOSMSharedPrefs()
                )

                mapView.setMultiTouchControls(true)
                mapView.getLocalVisibleRect(Rect())

                mapView.controller.setZoom(mapData.zoomLevel?.toDouble() ?: 0.0)
                mapView.controller.setCenter(
                    GeoPoint(
                        mapData.focusedLat ?: 0.0,
                        mapData.focusedLng ?: 0.0
                    )
                )
            }
        }
    )
}
