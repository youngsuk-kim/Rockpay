tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = true
}

dependencies {
    implementation(project(":api:api-support"))
    implementation(project(":api:api-common"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}
