plugins {

    alias(libs.plugins.com.dkexception.android.application)

    alias(libs.plugins.com.dkexception.hilt)
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
}

dependencies {

    // Modules
    implementation(project(":feature:main"))
}
