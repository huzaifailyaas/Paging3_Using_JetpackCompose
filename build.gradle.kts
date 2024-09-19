// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.10" apply false

}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.8.0") // Add this line
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.47")
        classpath("org.jetbrains.kotlin:kotlin-serialization:2.0.10")

    }
}
