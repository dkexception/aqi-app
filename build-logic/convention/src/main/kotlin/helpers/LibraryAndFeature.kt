package helpers

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal fun Project.applyCommonLibraryAndFeatureProperties() {

    with(pluginManager) {
        apply("com.android.library")
        apply("org.jetbrains.kotlin.android")
        apply("com.dkexception.hilt")
    }

    extensions.configure<LibraryExtension> {

        configureKotlin(this)

        configureCompose(this)

        configureTest(this)

        configureCore(this)

        defaultConfig.targetSdk = 34

        testOptions.animationsDisabled = true

        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
    }
}
