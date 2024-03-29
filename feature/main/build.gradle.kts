plugins {
    alias(libs.plugins.com.dkexception.android.feature)
}

android {

    namespace = "com.dkexception.aqiapp.feature.main"

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

    // Modules
    api(projects.feature.onboarding)
    api(projects.feature.auth)
    api(projects.feature.more)
}
