tasks.getByName("bootJar") {
    enabled = false
}

tasks.getByName("jar") {
    enabled = true
}

dependencies {
    implementation(project(":domain:domain-order"))
    implementation(project(":domain:domain-support"))
    implementation(project(":infrastructure:databases:db-order"))
    implementation(project(":clients:client-product"))
    runtimeOnly(project(":infrastructure:messaging"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}
