plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.gms.google-services") // If using Firebase or Google Services
}

android {
    compileSdk = 30 // Make sure this is the latest version you want to target

    defaultConfig {
        applicationId = "com.yourpackage.javisai" // Replace with your package name
        minSdk = 21 // Adjust as per your app's requirements
        targetSdk = 30 // Target SDK version

        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false // Enable if you want to obfuscate your code
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    // Optional: To support different build flavors if needed
    flavorDimensions("version")
    productFlavors {
        create("free") {
            applicationIdSuffix = ".free"
            versionNameSuffix = "-free"
        }
        create("paid") {
            applicationIdSuffix = ".paid"
            versionNameSuffix = "-paid"
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.5.0") // Make sure this is the right version for Kotlin
    implementation("androidx.core:core-ktx:1.5.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")

    // Add other dependencies for your app
    implementation("com.google.firebase:firebase-analytics:19.0.0") // Example, if you're using Firebase

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
