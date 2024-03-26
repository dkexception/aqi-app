package helpers

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Configure Compose-specific options
 */
internal fun Project.configureCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {

        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion("androidxComposeCompiler").get().toString()
        }

        dependencies {

            // Bill of Materials
            val bom = libs.findLibrary("androidx.compose.bom").get()

            // Main
            "implementation"(platform(bom))

            "implementation"(libs.findLibrary("androidx-activity-compose").get())
            "implementation"(libs.findLibrary("androidx-compose-runtime").get())
            "implementation"(libs.findLibrary("androidx-compose-foundation").get())
            "implementation"(libs.findLibrary("androidx-compose-foundation-layout").get())

            "implementation"(libs.findLibrary("androidx-compose-ui").get())
            "implementation"(libs.findLibrary("androidx-compose-ui-util").get())
            "implementation"(libs.findLibrary("androidx-compose-ui-graphics").get())
            "debugImplementation"(libs.findLibrary("androidx-compose-ui-tooling").get())
            "debugImplementation"(libs.findLibrary("androidx-compose-ui-testManifest").get())
            "debugImplementation"(libs.findLibrary("androidx-compose-ui-tooling-preview").get())

            "implementation"(libs.findLibrary("androidx-compose-material3").get())
            "implementation"(libs.findLibrary("androidx-compose-material-iconsExtended").get())

            "implementation"(libs.findLibrary("androidx-navigation-compose").get())

            // Test
            "androidTestImplementation"(platform((bom)))
        }
    }
}
