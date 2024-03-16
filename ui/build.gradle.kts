plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.dkexception.ui"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    // Testing
    testImplementation(TestImplementation.junit)
    testImplementation(TestImplementation.kotlinxCoroutine)
    androidTestImplementation(AndroidTestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.espresso)
}
