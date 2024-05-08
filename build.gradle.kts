import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.5.31"
    application
}
application{
    mainClass.set("com.example.ApplicationKt")
}
group = "org.example"
version = "0.0.1"

repositories {
    // inside this method repository we have all our ktor dependencies
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(kotlin("stdlib"))
    implementation("io.ktor:ktor-server-core:1.6.4")
    implementation("io.ktor:ktor-server-netty:1.6.4")
    //logs from server
    implementation("ch.qos.logback:logback-classic:1.2.6")
    implementation("io.ktor:ktor-serialization:1.6.4")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}