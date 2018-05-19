import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion: String by extra
buildscript {
    var kotlinVersion: String by extra
    kotlinVersion = "1.2.41"
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", kotlinVersion))
    }
}
plugins {
    java
    application
}
apply {
    plugin("kotlin")
}

application {
    mainClassName = "App"
}

dependencies {
    compile("com.google.guava:guava:23.0")
    testCompile("junit:junit:4.12")
    compile(kotlin("stdlib-jdk8", kotlinVersion))
}

repositories {
    jcenter()
    google()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}