tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = true
}

dependencies {
    implementation(project(":common"))
    implementation(project(":apis:api-support"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}
