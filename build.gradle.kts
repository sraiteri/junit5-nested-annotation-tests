plugins {
    id("java")
}

group = "au.com.shaneraiteri.junit5nestedannotationstests"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.11.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}