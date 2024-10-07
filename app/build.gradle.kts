plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //kotlin("plugin.serialization") version "2.0.20"
    alias(libs.plugins.kotlin.serialization)
    //kotlin("kapt") version "2.0.20"
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.isczaragoza.dogsapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.isczaragoza.dogsapp"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //Compose Navigation Type Safe
    implementation(libs.androidx.navigation.compose)
    //Dependency Injection
    implementation(libs.koin.androidx.compose)
    //HTTP Client
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    //Serialization Converter
    implementation(libs.retrofit.converter.kotlinx.serialization)
    //Serialization
    implementation(libs.kotlinx.serialization.json)
    //Database
    //implementation(libs.androidx.room.runtime)
    //annotationProcessor(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)
    //Load Images
    implementation(libs.coil.compose)
}