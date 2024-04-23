plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.testyrecipes"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.testyrecipes"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // Glide library
    implementation ("com.github.bumptech.glide:glide:4.6.1")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.6.1")
    // Volley library
    implementation ("com.android.volley:volley:1.2.1")
    // Recyclerview Library
    implementation ("com.android.support:recyclerview-v7:28.0.0")


}