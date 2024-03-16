plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")

    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.dkexception.feature.main"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        vectorDrawables {
            useSupportLibrary = true
        }
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
