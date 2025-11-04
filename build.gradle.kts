plugins {
    id("java")
}

group = "dev.jkit.ionview"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.test {
    useJUnitPlatform()
}