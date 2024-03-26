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
}
