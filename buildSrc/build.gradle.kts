import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.6.10"
}
repositories {
    gradlePluginPortal()
    google()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    maven("https://plugins.gradle.org/m2/")
    maven("https://repo.spring.io/plugins-release/")
}
dependencies {
    // android gradle plugin, required by custom plugin
    implementation("com.android.tools.build:gradle:7.0.2")
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
    // kotlin plugin, required by custom plugin
    implementation(kotlin("gradle-plugin", "1.6.10"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.10")

    implementation("com.github.ben-manes:gradle-versions-plugin:0.39.0")
    implementation("com.google.android.gms:strict-version-matcher-plugin:1.2.2")
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
