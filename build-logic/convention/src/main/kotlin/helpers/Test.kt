package helpers

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Configure Testing options
 */
internal fun Project.configureTest(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {

        dependencies {
            "testImplementation"(libs.findLibrary("junit-test").get())
            "testImplementation"(libs.findLibrary("kotlinx-coroutines-test").get())
            "androidTestImplementation"(libs.findLibrary("androidx-test-ext").get())
            "androidTestImplementation"(libs.findLibrary("androidx-test-espresso-core").get())
        }
    }
}
