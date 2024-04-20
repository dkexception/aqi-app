plugins {
    alias(libs.plugins.com.dkexception.android.library)
}

android {

    namespace = "com.dkexception.aqiapp.carapp"

    defaultConfig {

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {

    api(projects.feature.aqisdk)

    implementation(libs.car.app.library)
}
