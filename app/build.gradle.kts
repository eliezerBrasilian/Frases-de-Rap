plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "principal.fraseparastatus.frasesderapparastatus"
    compileSdk = 33

    defaultConfig {
        applicationId = "principal.fraseparastatus.frasesderapparastatus"
        minSdk = 24
        targetSdk = 33
        versionCode = 13
        versionName = "1.0.4"

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

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.recyclerview:recyclerview:1.3.1")
    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:32.2.3"))

    // Declare the dependency for the Cloud Firestore library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-firestore-ktx")

    implementation("com.google.firebase:firebase-analytics-ktx")

    //circular image
    implementation ("de.hdodenhof:circleimageview:3.1.0")

    //google ads
    implementation( "com.google.android.gms:play-services-ads:22.4.0")
}