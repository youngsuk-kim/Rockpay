tasks.getByName("bootJar") {
    enabled = false
}

tasks.getByName("jar") {
    enabled = true
}

dependencies {
    implementation(project(":domain:domain-order"))
    implementation(project(":domain:domain-support"))
    implementation("org.springframework.boot:spring-boot-starter")
}
