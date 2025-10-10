rootProject.name = "Rockpay"

include(
    "apis:api-core",
    "apis:api-order",
    "apis:api-docs",
    "applications:app-core",
    "applications:app-order",
    "domain:domain-order",
    "domain:domain-core",
    "domain:domain-support",
    "infrastructure:databases:db-core",
    "infrastructure:databases:db-order",
    "infrastructure:messaging",
    "clients:client-example",
    "clients:client-product",
    "utils"
)

pluginManagement {
    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
    val ktlintVersion: String by settings

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.kapt" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.spring" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.jpa" -> useVersion(kotlinVersion)
                "org.springframework.boot" -> useVersion(springBootVersion)
                "io.spring.dependency-management" -> useVersion(springDependencyManagementVersion)
                "org.jlleitschuh.gradle.ktlint" -> useVersion(ktlintVersion)
            }
        }
    }
}
