import helpers.applyCommonLibraryAndFeatureProperties
import helpers.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {

        with(target) {

            applyCommonLibraryAndFeatureProperties()

            dependencies {

                "api"(project(":ui"))
                "implementation"(project(":core"))

                "implementation"(libs.findLibrary("lifecycle-runtime-compose").get())

//                add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
//                add("implementation", libs.findLibrary("androidx.lifecycle.viewModelCompose").get())
            }
        }
    }
}
