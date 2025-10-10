tasks.getByName("bootJar") {
    enabled = false
}

tasks.getByName("jar") {
    enabled = true
}

dependencies {
    implementation(project(":domain:domain-core"))
    implementation(project(":domain:domain-support"))
    implementation(project(":infrastructure:messaging"))
    runtimeOnly(project(":infrastructure:databases:db-core"))
    implementation("org.springframework.boot:spring-boot-starter")
}
