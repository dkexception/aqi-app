import java.util.Properties

plugins {
    alias(libs.plugins.com.dkexception.android.library)
}

fun readProperties(propertiesFile: File) = Properties().apply {
    propertiesFile.inputStream().use { fis ->
        load(fis)
    }
}

android {

    namespace = "com.dkexception.aqiapp.core"

    defaultConfig {

        consumerProguardFiles("consumer-rules.pro")

        val localProjectProperties = readProperties(rootProject.file("local.properties"))

        val airVisualAPIKey: String =
            (localProjectProperties["airVisualAPIKey"] as? String).orEmpty()

        val airVisualAPIBaseURL: String =
            (localProjectProperties["airVisualAPIBaseURL"] as? String).orEmpty()

        buildConfigField("String", "airVisualAPIKey", "\"$airVisualAPIKey\"")
        buildConfigField("String", "airVisualAPIBaseURL", "\"$airVisualAPIBaseURL\"")
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

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.gson)
    implementation(libs.gson.converter)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)

    // Encrypted Shared Prefs
    implementation(libs.androidx.security.crypto)
}
