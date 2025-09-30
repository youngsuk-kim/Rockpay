plugins {
    id("org.jetbrains.kotlin.plugin.jpa")
}

tasks.getByName("bootJar") {
    enabled = false
}

tasks.getByName("jar") {
    enabled = true
}

dependencies {
    implementation(project(":api:api-common"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}
