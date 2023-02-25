plugins {
    id("java")
}

group = "ru.sample"
version = "1.0.0"

repositories {
    mavenCentral()
}

tasks.jar {
    manifest {
        archiveBaseName.set("sample")
        attributes["Main-Class"] = "Application"
    }
}
