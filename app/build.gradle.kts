plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.dkexception.aqiapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dkexception.aqiapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.KOTLIN_COMPILER_EXT_VERSION
    }
}

dependencies {

    // Modules
    implementation(project(Modules.Feature.MAIN))

    // Core
    implementation(Core.coreKtx)
    implementation(Core.appCompat)
    implementation(Core.material)

    // Compose
    implementation(Core.activityCompose)
    implementation(platform(ComposeBOM.composeBom))
    implementation(ComposeBOM.composeUI)
    implementation(ComposeBOM.composeGraphics)
    implementation(ComposeBOM.composeUIPreview)
    implementation(ComposeBOM.composeMaterial3)

    // Hilt
    implementation(DaggerHilt.hilt)
    implementation(DaggerHilt.hiltComposeNavigation)
    kapt(DaggerHilt.hiltAndroidCompiler)

    // Testing
    testImplementation(TestImplementation.junit)
    testImplementation(TestImplementation.kotlinxCoroutine)
    androidTestImplementation(AndroidTestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.espresso)
}
