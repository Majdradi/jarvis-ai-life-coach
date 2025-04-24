// Root-level build.gradle file

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Classpath for the Android Gradle plugin
        classpath 'com.android.tools.build:gradle:7.0.2'  // Update to the latest version if necessary
        // Firebase or Google Services if needed
        classpath 'com.google.gms:google-services:4.3.10'  // Update to the latest version if necessary
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

