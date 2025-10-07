tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = true
}

dependencies {
    testImplementation(project(":apis:api-docs"))
    api(project(":apis:api-support"))
    implementation(project(":common"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}
