package com.dkexception.ui.maps.data

data class MapData(
    val focusedLat: Double? = null,
    val focusedLng: Double? = null,
    val zoomLevel: Float? = null,
    val allowScrolling: Boolean = true,
    val onMapClicked: () -> Unit
)
