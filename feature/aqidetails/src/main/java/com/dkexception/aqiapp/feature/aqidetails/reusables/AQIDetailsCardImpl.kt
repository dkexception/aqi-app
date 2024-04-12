package com.dkexception.aqiapp.feature.aqidetails.reusables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dkexception.aqiapp.feature.aqidetails.R
import com.dkexception.aqiapp.feature.aqidetails.contract.IAQIDetailsCard
import com.dkexception.aqiapp.feature.aqisdk.model.AQILevel
import com.dkexception.aqiapp.feature.aqisdk.model.AirQualityData
import com.dkexception.aqiapp.feature.aqisdk.model.PollutionData
import com.dkexception.aqiapp.feature.aqisdk.model.WeatherData
import com.dkexception.ui.cards.DXCard
import com.dkexception.ui.images.DXNetworkImage
import com.dkexception.ui.maps.IMapView
import com.dkexception.ui.maps.data.MapData
import com.dkexception.ui.maps.providers.MapProvider
import com.dkexception.ui.theme.DXColors
import com.dkexception.ui.theme.DXPaddings
import com.dkexception.ui.theme.headline1
import com.dkexception.ui.theme.headline2
import com.dkexception.ui.theme.light
import com.dkexception.ui.theme.medium
import javax.inject.Inject

internal class AQIDetailsCardImpl @Inject constructor(
    private val mMapView: IMapView
) : IAQIDetailsCard {

    @Composable
    override fun AQIDetailsCard(aqiData: AirQualityData) = AQIDetailsCardContent(
        aqiData = aqiData,
        mMapView = mMapView
    )
}

@Composable
private fun AQIDetailsCardContent(
    aqiData: AirQualityData,
    mMapView: IMapView
) = DXCard(
    modifier = Modifier.fillMaxWidth(),
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    when (aqiData.americaLevel) {
                        AQILevel.UNKNOWN -> DXColors.aqiLevel.unknown
                        AQILevel.GOOD -> DXColors.aqiLevel.good
                        AQILevel.MODERATE -> DXColors.aqiLevel.moderate
                        AQILevel.BAD -> DXColors.aqiLevel.bad
                        AQILevel.POOR -> DXColors.aqiLevel.poor
                        AQILevel.UNHEALTHY -> DXColors.aqiLevel.unhealthy
                        AQILevel.HAZARDOUS -> DXColors.aqiLevel.hazardous
                    }
                )
                .padding(DXPaddings.default)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(
                        id = if (aqiData.isFromIPLocation) {
                            R.drawable.ic_iplocation
                        } else {
                            R.drawable.ic_gps
                        }
                    ),
                    contentDescription = null,
                    tint = DXColors.primary.default
                )

                Spacer(modifier = Modifier.width(DXPaddings.default))

                Column {

                    Text(
                        text = aqiData.city.orEmpty(),
                        style = medium(),
                        color = DXColors.text.dark,
                        textAlign = TextAlign.Start
                    )

                    Text(
                        text = "${aqiData.state.orEmpty()}, ${aqiData.country.orEmpty()}",
                        style = light(),
                        color = DXColors.text.light,
                        textAlign = TextAlign.Start,
                    )
                }

                Spacer(Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.ic_temperature),
                    contentDescription = null,
                    tint = DXColors.primary.default
                )

                Spacer(modifier = Modifier.width(DXPaddings.default))

                Text(
                    text = "${aqiData.weatherData.temperature?.toInt()}",
                    style = headline2(),
                    color = DXColors.text.dark,
                    textAlign = TextAlign.Start
                )

                Text(
                    text = "°C",
                    style = light(),
                    color = DXColors.text.dark,
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.width(DXPaddings.default))

                DXNetworkImage(
                    modifier = Modifier.size(DXPaddings.xLarge),
                    imageUrl = aqiData.weatherData.weatherIconUrl
                )
            }

            Spacer(modifier = Modifier.height(DXPaddings.large))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_aqi),
                    contentDescription = null,
                    modifier = Modifier.size(DXPaddings.large),
                    tint = DXColors.primary.default
                )

                Spacer(modifier = Modifier.width(DXPaddings.default))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column {

                        Text(
                            text = "${aqiData.pollutionData.aqiAmericaEPA}",
                            style = headline1(),
                            color = DXColors.text.dark,
                            textAlign = TextAlign.Start
                        )

                        Text(
                            text = "EPA, America",
                            style = light(),
                            color = DXColors.text.light,
                            textAlign = TextAlign.Start
                        )
                    }

                    Column {

                        Text(
                            text = "${aqiData.pollutionData.aqiChinaMEP}",
                            style = headline1(),
                            color = DXColors.text.dark,
                            textAlign = TextAlign.Start
                        )

                        Text(
                            text = "MEP, China",
                            style = light(),
                            color = DXColors.text.light,
                            textAlign = TextAlign.Start
                        )
                    }
                }
            }
        }

        mMapView.DefaultMapView(
            mapData = MapData(
                focusedLat = aqiData.latLng?.first,
                focusedLng = aqiData.latLng?.second,
                zoomLevel = 10.0f,
                allowScrolling = false
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}

@Preview
@Composable
private fun AQIDetailsIPLocationCardPreview() = AQIDetailsCardContent(
    aqiData = AirQualityData(
        isFromIPLocation = true,
        chinaLevel = AQILevel.MODERATE,
        americaLevel = AQILevel.HAZARDOUS,
        city = "Pune",
        state = "Maharashtra",
        country = "India",
        latLng = 18.64 to 73.84,
        pollutionData = PollutionData(
            aqiChinaMEP = 80,
            mainPollutantChina = "p2",
            aqiAmericaEPA = 153,
            mainPollutantAmerica = "p2",
            timestamp = "2024-04-12T07:00:00.000Z"
        ),
        weatherData = WeatherData(
            humidityPercent = 21.0,
            weatherIconUrl = "https://airvisual.com/images/04d.png",
            pressureHPA = 1010.0,
            temperature = 35.0,
            windDirectionAngle = 160.0,
            windSpeedMPS = 3.03,
            timestamp = "2024-04-12T08:00:00.000Z"
        )
    ),
    mMapView = object : IMapView {
        @Composable
        override fun DefaultMapView(mapData: MapData, modifier: Modifier) {
            Box(modifier = modifier.background(Color.Cyan))
        }

        @Composable
        override fun MapViewForProvider(
            provider: MapProvider,
            mapData: MapData,
            modifier: Modifier
        ) = Box(modifier = modifier.background(Color.Cyan))
    }
)

@Preview
@Composable
private fun AQIDetailsGPSCardPreview() = AQIDetailsCardContent(
    aqiData = AirQualityData(
        isFromIPLocation = false,
        chinaLevel = AQILevel.MODERATE,
        americaLevel = AQILevel.BAD,
        city = "Pune",
        state = "Maharashtra",
        country = "India",
        latLng = 18.64 to 73.84,
        pollutionData = PollutionData(
            aqiChinaMEP = 80,
            mainPollutantChina = "p2",
            aqiAmericaEPA = 153,
            mainPollutantAmerica = "p2",
            timestamp = "2024-04-12T09:00:00.000Z"
        ),
        weatherData = WeatherData(
            humidityPercent = 21.0,
            weatherIconUrl = "https://airvisual.com/images/04d.png",
            pressureHPA = 1010.0,
            temperature = 35.0,
            windDirectionAngle = 160.0,
            windSpeedMPS = 3.03,
            timestamp = "2024-04-12T10:00:00.000Z"
        )
    ),
    mMapView = object : IMapView {
        @Composable
        override fun DefaultMapView(mapData: MapData, modifier: Modifier) {
            Box(modifier = modifier.background(Color.Cyan))
        }

        @Composable
        override fun MapViewForProvider(
            provider: MapProvider,
            mapData: MapData,
            modifier: Modifier
        ) = Box(modifier = modifier.background(Color.Cyan))
    }
)
