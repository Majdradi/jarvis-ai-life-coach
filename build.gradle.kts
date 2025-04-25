buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.2") // Android Gradle plugin
        classpath("com.google.gms:google-services:4.3.10") // Firebase/Google Services if needed
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
