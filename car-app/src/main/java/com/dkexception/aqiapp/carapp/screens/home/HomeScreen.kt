package com.dkexception.aqiapp.carapp.screens.home

import android.text.Spannable
import android.text.SpannableString
import androidx.car.app.AppManager
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.SurfaceCallback
import androidx.car.app.SurfaceContainer
import androidx.car.app.annotations.ExperimentalCarApi
import androidx.car.app.model.Action
import androidx.car.app.model.CarColor
import androidx.car.app.model.CarLocation
import androidx.car.app.model.Distance
import androidx.car.app.model.DistanceSpan
import androidx.car.app.model.Header
import androidx.car.app.model.Metadata
import androidx.car.app.model.Pane
import androidx.car.app.model.PaneTemplate
import androidx.car.app.model.Place
import androidx.car.app.model.PlaceMarker
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.car.app.navigation.model.MapController
import androidx.car.app.navigation.model.MapTemplate
import androidx.lifecycle.lifecycleScope
import com.dkexception.aqiapp.feature.aqisdk.contract.IAirVisualDataManager
import com.dkexception.core.model.TaskResult
import kotlinx.coroutines.launch
import java.util.Locale

class HomeScreen(
    carContext: CarContext,
    private val aqiDataManager: IAirVisualDataManager
) : Screen(carContext) {

    private var state = HomeScreenState()

    init {
        lifecycleScope.launch {
            getCurrentAQIByIPLocation()
        }
    }

    private suspend fun getCurrentAQIByIPLocation() {
        when (val currentAQIDataResult = aqiDataManager.getDataByIPLocation()) {
            is TaskResult.Error -> {
                state = state.copy(
                    isError = true,
                    isLoading = false
                )
            }

            is TaskResult.Success -> {
                state = state.copy(
                    isLoading = false,
                    isError = false,
                    aqiData = currentAQIDataResult.data
                )
            }
        }
        invalidate()
    }

    @ExperimentalCarApi
    override fun onGetTemplate(): Template {

        if (state.isLoading) {

            return getLoadingPaneTemplate()
        }

        val aqiToShow: Int = state.aqiData.pollutionData.aqiAmericaEPA ?: 0

        val aqiLevel: String = state.aqiData.americaLevel.name
            .lowercase()
            .replaceFirstChar {
                if (it.isLowerCase()) {
                    it.titlecase(
                        Locale.getDefault()
                    )
                } else {
                    it.toString()
                }
            }

        carContext.getCarService(AppManager::class.java).setSurfaceCallback(
            object : SurfaceCallback {

                override fun onSurfaceAvailable(surfaceContainer: SurfaceContainer) {
                    super.onSurfaceAvailable(surfaceContainer)
                    surfaceContainer.surface
                }
            }
        )

        return MapTemplate.Builder()
            .setMapController(
                MapController.Builder().build()
            )
            .setHeader(
                Header.Builder()
                    .setTitle("AQI near you")
                    .setStartHeaderAction(Action.APP_ICON)
                    .build()
            )
            .setPane(
                Pane.Builder()
                    .addRow(
                        Row.Builder()
                            .setTitle("$aqiToShow ($aqiLevel level)")
                            .addText(SpannableString(" ").apply {
                                setSpan(
                                    DistanceSpan.create(
                                        Distance.create(Math.random() * 100, Distance.UNIT_KILOMETERS)
                                    ), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                                )
                            })
                            .setMetadata(
                                Metadata.Builder()
                                    .setPlace(
                                        Place.Builder(
                                            CarLocation.create(
                                                state.aqiData.latLng?.first ?: 0.0,
                                                state.aqiData.latLng?.second ?: 0.0,
                                            )
                                        ).setMarker(
                                            PlaceMarker.Builder()
                                                .setColor(CarColor.BLUE)
                                                .build()
                                        )
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
            .build()
    }

    /**
     * Get a new loading pane template
     */
    private fun getLoadingPaneTemplate(): PaneTemplate {

        val pane = Pane.Builder()
            .setLoading(true)
            .build()

        return PaneTemplate.Builder(pane)
//            .setHeader(
//                Header.Builder()
//                    .setTitle("AQI near you")
//                    .setStartHeaderAction(Action.APP_ICON)
//                    .build()
//            )
            .build()
    }
}
