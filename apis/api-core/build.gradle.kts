tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = true
}

dependencies {
    runtimeOnly(project(":infrastructure:databases:db-core"))
    runtimeOnly(project(":infrastructure:messaging"))
    implementation(project(":applications:app-core"))
    implementation(project(":domain:domain-core"))
    implementation(project(":domain:domain-support"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation(project(":apis:api-docs"))
}
