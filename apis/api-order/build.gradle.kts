tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = true
}

dependencies {
    implementation(project(":applications:app-order"))
    implementation(project(":domain:domain-order"))
    runtimeOnly(project(":infrastructure:messaging"))
    testImplementation(project(":apis:api-docs"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}
