plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")

    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.dkexception.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
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

    // Hilt
    implementation(DaggerHilt.hilt)
    implementation(DaggerHilt.hiltComposeNavigation)
    kapt(DaggerHilt.hiltAndroidCompiler)

    // Retrofit
    implementation(Retrofit.retrofit)
    implementation(Retrofit.gson)
    implementation(Retrofit.gsonConvertor)
    implementation(Retrofit.okHttp)
    implementation(Retrofit.okHttpLoggingInterceptor)

    // Testing
    testImplementation(TestImplementation.junit)
    testImplementation(TestImplementation.kotlinxCoroutine)
    androidTestImplementation(AndroidTestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.espresso)
}
