plugins {

    alias(libs.plugins.com.dkexception.android.application)
}

android {

    namespace = "com.dkexception.aqiapp"

    defaultConfig {

        applicationId = "com.dkexception.aqiapp"

        versionCode = 1
        versionName = "1.0"
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

    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    // Common
    api(projects.ui)

    // Modules
    api(projects.feature.onboarding)
    api(projects.feature.auth)
    api(projects.feature.home)
    api(projects.feature.databank)
    api(projects.feature.more)
    api(projects.feature.aqidetails)
}
