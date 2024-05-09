plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("kotlin-kapt")
}

android {
    namespace = "com.arjungupta08.androidmvvmtesting"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.arjungupta08.androidmvvmtesting"
        minSdk = 24
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    testImplementation (libs.androidx.core.testing.v210)
    androidTestImplementation (libs.core.testing)

    implementation (libs.retrofit)
    implementation (libs.okhttp)
    implementation (libs.logging.interceptor)
    implementation (libs.converter.gson)
    implementation (libs.gson)

    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)
    testImplementation (libs.kotlinx.coroutines.test)

    implementation (libs.androidx.lifecycle.viewmodel.ktx)

    implementation (libs.glide)
    kapt ("com.github.bumptech.glide:compiler:4.12.0")

    testImplementation (libs.mockwebserver)

    testImplementation (libs.mockito.core)
    testImplementation (libs.mockito.kotlin)


}