package helpers

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Configure Core options
 */
internal fun Project.configureCore(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {

        dependencies {

            "implementation"(libs.findLibrary("androidx-core").get())
            "implementation"(libs.findLibrary("androidx-appcompat").get())
            "implementation"(libs.findLibrary("google-material").get())
        }
    }
}
