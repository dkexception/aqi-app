![AQI App's Overview](./images/aqi-app-cover.png)

# AQI App
* Air Quality Index app is an app showcasing all the latest Jetpack Compose techniques implemented properly, and follows multi-module architecture.
* This app can be used as a reference or as a learning journey for Jetpack Compose.

# Primary tools
1. Android Application in Kotlin
2. UI based on pure Jetpack Compose
3. Uses [AirVisual API](https://api-docs.iqair.com) to get the Air Quality Data
4. Follows modern MVI Event Driven modular architecture

# Architecture
1. This app showcases multi-module MVI Event Driven architecture with Jetpack libraries
2. UI being fully made with Jetpack Compose
3. HILT is used as the Dependency Injection framework
4. All the popular Android libraries such as Retrofit, Coil, Coroutines, Flows are used as well

# Build steps
This app is based on an API to fetch the Air Quality data, so we need the key for that API. Also, to display Geographical maps, we have added support of 3 different map providers viz. Google Maps, Mappls (Map My India) and OpenStreetMaps (OSM). Using the Google & Mappls maps require their own keys as well. The entire process is as follows:
## Air Quality Data API
1. Login / Create Account at the [IQAir Dashboard](https://dashboard.iqair.com/auth/sign-in)
2. Get your own AirVisual API key
3. Put that key in `local.properties` file as: `airVisualAPIKey=<YOUR KEY HERE>`
4. Also add the default Base URL in the same file as: `airVisualAPIBaseURL=https://api.airvisual.com/`
## Google Maps key
1. To get the Google maps key, you first need to create a project in the [Google Maps Console](https://console.cloud.google.com/google/maps-apis)
2. Using this project, get a new API key to access Google maps (Don't forget to secure the API key by adding debug SHA-1 fingerprints)
3. Add that key to the `local.properties` file as: `MAPS_API_KEY=<YOUR KEY HERE>`
## Mappls Maps key
1. To get the Mappls maps key, you first need to create a project in the [Mappls Maps Console](https://apis.mappls.com/console)
2. Using this project, get a new API key, Client ID & Client Secret to access Mappls maps
3. Add all the credentials to the `local.properties` file as follows:
```
mapMyIndiaKey=<YOUR KEY HERE>
mapMyIndiaClientId=<YOUR CLIENT ID HERE>
mapMyIndiaClientSecret=<YOUR CLIENT SECRET HERE>
```
Now Build and run the app as usual

# UI / UX Attribution
* The UI for this app is created by Anamoul Rouf, as mentioned in [Contra page](https://contra.com/p/Oqrgl3MW-a-real-time-aqi-app-air-quality-index-with-weather-forecast) and I highly appreciate the beauty and efforts behind this design.
* The Figma designs are available to use as - [AirQI Air Quality & Weather App](https://www.figma.com/community/file/1252862797736025351) under CC BY 4.0 DEED
