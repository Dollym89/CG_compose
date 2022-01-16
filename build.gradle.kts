import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

// Top-level build file where you can add configuration options common to all sub-projects/modules.

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    id("com.github.ben-manes.versions")
}

// For more see https://github.com/ben-manes/gradle-versions-plugin
tasks.withType<DependencyUpdatesTask> {
    gradleReleaseChannel = "current"
    rejectVersionIf {
        isStable(currentVersion) && !isStable(candidate.version)
    }
}

fun isStable(version: String): Boolean {
    val keyword = setOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    return keyword || regex.matches(version)
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}