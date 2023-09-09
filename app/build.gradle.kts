plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.davecon.navigationbarapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.davecon.navigationbarapp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val nav_version = "2.4.0-alpha10"
    val compose_ui_version = "1.1.1"
    val compose_bom_version = "2023.03.00"
    val compose_activity_version = "1.7.2"
    val core_ktx_version = "1.9.0"
    val ktx_runtime_version = "2.6.1"
    val junit_version = "4.13.2"
    val test_junit_version = "1.1.5"
    val espresso_version = "3.5.1"

    implementation("androidx.core:core-ktx:$core_ktx_version")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$ktx_runtime_version")
    implementation("androidx.activity:activity-compose:$compose_activity_version")
    implementation(platform("androidx.compose:compose-bom:$compose_bom_version"))
    implementation("androidx.compose.ui:ui:$compose_ui_version")
    implementation("androidx.compose.ui:ui-graphics:$compose_ui_version")
    implementation("androidx.compose.ui:ui-tooling-preview:$compose_ui_version")
    implementation("androidx.compose.material3:material3:$compose_ui_version")
    implementation("androidx.compose.material3:material3-icons-extended")
    implementation("androidx.compose.navigation:navigation-compose:$nav_version")
    implementation("androidx.compose.material3:material3-window-size-class:$compose_ui_version")

    // Test
    testImplementation("junit:junit:$junit_version")
    androidTestImplementation("androidx.test.ext:junit:$test_junit_version")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espresso_version")
    androidTestImplementation(platform("androidx.compose:compose-bom:$compose_bom_version"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4$compose_ui_version")
    debugImplementation("androidx.compose.ui:ui-tooling$compose_ui_version")
    debugImplementation("androidx.compose.ui:ui-test-manifest$compose_ui_version")
    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")
}