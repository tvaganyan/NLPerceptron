
plugins {
    `java-library`
    kotlin("jvm") version "1.3.41"
}

dependencies {
    api(kotlin("stdlib-jdk8"))

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
}

repositories {
    jcenter()
}
