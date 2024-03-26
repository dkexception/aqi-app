import helpers.applyCommonLibraryAndFeatureProperties
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {

        with(target) {

            applyCommonLibraryAndFeatureProperties()

            dependencies {

                "implementation"(project(":ui"))
                "implementation"(project(":core"))

//                add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
//                add("implementation", libs.findLibrary("androidx.lifecycle.viewModelCompose").get())
            }
        }
    }
}
