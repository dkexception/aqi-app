package com.dkexception.aqiapp.carapp.screens.details

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.annotations.ExperimentalCarApi
import androidx.car.app.model.Action
import androidx.car.app.model.CarIcon
import androidx.car.app.model.Header
import androidx.car.app.model.MessageTemplate
import androidx.car.app.model.Template
import androidx.car.app.navigation.model.MapWithContentTemplate
import com.dkexception.aqiapp.feature.aqisdk.model.AirQualityData
import java.util.Locale

class DetailsScreen(
    carContext: CarContext,
    private val aqiData: AirQualityData
) : Screen(carContext) {

    @ExperimentalCarApi
    override fun onGetTemplate(): Template {

        val aqiToShow: Int = aqiData.pollutionData.aqiAmericaEPA ?: 0

        val aqiLevel: String = aqiData.americaLevel.name
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

        val contentTemplate = MessageTemplate.Builder(
            "Primary AQI near you is $aqiToShow, which indicates $aqiLevel level."
        )
//            .setHeader(
//                Header.Builder()
//                    .setStartHeaderAction(Action.BACK)
//                    .build()
//            )
            .setIcon(CarIcon.APP_ICON)
            .build()

        return MapWithContentTemplate.Builder()
            .setContentTemplate(contentTemplate)
            .build()
    }
}
