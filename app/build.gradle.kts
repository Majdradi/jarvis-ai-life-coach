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
            storeFile file("your-release-key.jks")  // Path to your keystore file
            storePassword "your-store-password"  // Keystore password
            keyAlias "your-key-alias"  // Key alias
            keyPassword "your-key-password"  // Key password
        }
    }

    buildTypes {
        release {
            signingConfig signingConfigs.release
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation 'androidx.appcompat:appcompat:1.3.0'  // Example dependency
    // Add any other dependencies you need for your app
}
