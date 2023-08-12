plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

var spring = "6.0.8"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-context:$spring")
}
