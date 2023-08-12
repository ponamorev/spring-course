plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

var lombok = "1.18.28"
var spring = "6.0.8"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:$lombok")
    annotationProcessor("org.projectlombok:lombok:$lombok")

    implementation("org.springframework:spring-context:$spring")
}