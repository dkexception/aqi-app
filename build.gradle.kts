plugins {

    // Android
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.test) apply false

    // Kotlin
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.ksp) apply false

    // HILT
    alias(libs.plugins.hilt) apply false

    // Google map secrets plugin
    alias(libs.plugins.google.map.secrets) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
}
