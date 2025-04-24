buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:7.0.2'  // Make sure this is the right version
        classpath 'com.google.gms:google-services:4.3.10'  // If you're using Firebase
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
