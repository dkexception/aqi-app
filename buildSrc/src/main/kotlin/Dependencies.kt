object Version {

    // Core
    const val CORE_KTX = "1.10.1"
    const val APP_COMPAT = "1.6.1"
    const val MATERIAL = "1.11.0"
    const val ACTIVITY_COMPOSE = "1.7.2"

    // Everything Compose
    const val KOTLIN_COMPILER_EXT_VERSION = "1.5.1"
    const val COMPOSE_BOM = "2024.02.02"

    // Navigation
    const val NAVIGATION = "2.7.5"

    // Coroutines
    const val KOTLIN_COROUTINE = "1.6.4"

    // Lifecycle
    const val LIFECYCLE = "2.5.1"
    const val LIFECYCLE_COMPOSE = "2.6.1"
    const val LIFECYCLE_RUNTIME_COMPOSE = "2.6.0"

    // LiveData
    const val LIVE_DATA = "2.6.1"

    // Networking
    const val RETROFIT = "2.9.0"
    const val GSON_CONVERTER = "2.9.0"
    const val GSON = "2.10.1"
    const val OKHTTP = "4.10.0"

    // Dagger-Hilt
    const val HILT = "2.50"
    const val HILT_COMPOSE_NAV = "1.2.0"

    // Coil
    const val COIL = "2.4.0"

    //Data Store
    const val DATA_STORE_VERSION = "1.0.0"

    // Testing
    const val TEST_RUNNER = "1.5.2"
    const val TEST_IMPL_RUNNER = "4.13.2"
    const val ANDROID_TEST_IMPL_RUNNER = "1.1.3"
    const val ANDROID_TEST_ESPRESSO = "3.4.0"
}

object Modules {

    const val CORE = ":core"

    const val UI = ":ui"

    object Feature {
        const val MAIN = ":feature:main"
    }
}

object Core {
    const val coreKtx = "androidx.core:core-ktx:${Version.CORE_KTX}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.APP_COMPAT}"
    const val activityCompose = "androidx.activity:activity-compose:${Version.ACTIVITY_COMPOSE}"
    const val material = "com.google.android.material:material:${Version.MATERIAL}"
}

object ComposeBOM {
    const val composeBom = "androidx.compose:compose-bom:${Version.COMPOSE_BOM}"
    const val composeUI = "androidx.compose.ui:ui"
    const val foundation = "androidx.compose.foundation:foundation"
    const val composeGraphics = "androidx.compose.ui:ui-graphics"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composeMaterial = "androidx.compose.material:material"
    const val composeLiveData = "androidx.compose.runtime:runtime-livedata"

    const val composeUIPreview = "androidx.compose.ui:ui-tooling-preview"
    const val debug_composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val debug_composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
}

object Navigation {
    const val navCompose = "androidx.navigation:navigation-compose:${Version.NAVIGATION}"
}

object Coroutines {
    const val coroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.KOTLIN_COROUTINE}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.KOTLIN_COROUTINE}"
}

object Lifecycle {
    const val lifeCycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.LIFECYCLE}"
    const val lifecycleViewModelCompose =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.LIFECYCLE_COMPOSE}"
    const val lifecycleRuntimeCompose =
        "androidx.lifecycle:lifecycle-runtime-compose:${Version.LIFECYCLE_RUNTIME_COMPOSE}"
}

object LiveData {
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.LIVE_DATA}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.RETROFIT}"
    const val gsonConvertor = "com.squareup.retrofit2:converter-gson:${Version.GSON_CONVERTER}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Version.OKHTTP}"
    const val okHttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Version.OKHTTP}"
    const val gson = "com.google.code.gson:gson:${Version.GSON}"
}

object Coil {
    const val coilKt = "io.coil-kt:coil:${Version.COIL}"
    const val coilCompose = "io.coil-kt:coil-compose:${Version.COIL}"
}

object DaggerHilt {
    const val hilt = "com.google.dagger:hilt-android:${Version.HILT}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Version.HILT}"
    const val hiltComposeNavigation =
        "androidx.hilt:hilt-navigation-compose:${Version.HILT_COMPOSE_NAV}"
}

object TestImplementation {
    const val junit = "junit:junit:${Version.TEST_IMPL_RUNNER}"
    const val kotlinxCoroutine =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.KOTLIN_COROUTINE}"
}

object AndroidTestImplementation {
    const val junit = "androidx.test.ext:junit:${Version.ANDROID_TEST_IMPL_RUNNER}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.ANDROID_TEST_ESPRESSO}"
}

object DataStore {
    const val preference = "androidx.datastore:datastore-preferences:${Version.DATA_STORE_VERSION}"
}
