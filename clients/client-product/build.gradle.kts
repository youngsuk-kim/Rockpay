plugins {
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.plugin.spring")
    kotlin("jvm")
}

dependencies {
    implementation(project(":domain:domain-core"))
    implementation(project(":domain:domain-support"))

    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
