import com.android.build.api.dsl.ApplicationExtension
import helpers.configureCompose
import helpers.configureCore
import helpers.configureTest
import helpers.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {

        with(target) {

            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("com.dkexception.hilt")
            }

            extensions.configure<ApplicationExtension> {

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
    }
}
