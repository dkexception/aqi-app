plugins {
    alias(libs.plugins.com.dkexception.android.feature)
}

android {

    namespace = "com.dkexception.aqiapp.feature.more"

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
