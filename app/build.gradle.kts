// App-level build.gradle file (for Jarvis AI Life Coach app)

plugins {
    id 'com.android.application'
    id 'kotlin-android'  // If you're using Kotlin
}

android {
    compileSdkVersion 30

    defaultConfig {
        applicationId "com.yourapp.jarvis"  // Replace with your actual package name
        minSdkVersion 21
        targetSdkVersion 30
        versionCode 1
        versionName "1.0"
    }

    signingConfigs {
        release {
            // Update these with the actual path and passwords if you're signing your APK for release
            storeFile file("path/to/your/keystore.jks")  // Replace with the actual path to your keystore file
            storePassword "your-store-password"  // Replace with your keystore password
            keyAlias "your-key-alias"  // Replace with your key alias
            keyPassword "your-key-password"  // Replace with your key password
        }
    }

    buildTypes {
        release {
            signingConfig signingConfigs.release
            minifyEnabled false  // If you want to enable ProGuard, set this to true
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }

    // Optional: If you're working with Kotlin, make sure it's enabled here
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation 'androidx.appcompat:appcompat:1.3.0'  // Update as needed
    implementation 'androidx.constraintlayout:constraintlayout:2.1.0'  // Update as needed
    implementation 'com.google.android.material:material:1.4.0'  // Update as needed

    // If using Kotlin
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"

    // Other dependencies as needed for your app
    // E.g., for Google Fit API
    implementation 'com.google.android.gms:play-services-fitness:20.0.0'  // Update if needed

    // If you're using Firebase or other services, add their dependencies here
    // Example:
    // implementation 'com.google.firebase:firebase-analytics:19.0.0'  // Example Firebase dependency
}
