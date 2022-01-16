import Dependency.AndroidX.cardView
import Dependency.AndroidX.constraintLayout
import Dependency.AndroidX.fragment
import Dependency.AndroidX.multidex
import Dependency.AndroidX.recyclerView
import Dependency.Google.material
import Dependency.Navigation.navigation_fragment
import Dependency.Navigation.navigation_ktx
import Dependency.Navigation.navigation_runtime
import Dependency.OkHttp.http_logger
import Dependency.OkHttp.http_runtime
import Dependency.OkHttp.http_urlConnection
import Dependency.Retrofit.converterGson
import Dependency.picasso
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.android.gms.strict-version-matcher-plugin")
}
val baseUrl = gradleLocalProperties(rootDir).getProperty("BASE_URL")
val userNamed = gradleLocalProperties(rootDir).getProperty("USER_NAME")
val pass = gradleLocalProperties(rootDir).getProperty("PASSWORD")
val ingThumbUrl = gradleLocalProperties(rootDir).getProperty("INGREDIENT_THUMB_IMG_URL")
val ingFullThumbUrl = gradleLocalProperties(rootDir).getProperty("INGREDIENT_FULL_IMG_URL")
val cockThumbUrl = gradleLocalProperties(rootDir).getProperty("COCK_THUMB_IMG_URL")

android {
    compileSdk = Application.Sdk.compile

    defaultConfig {
        applicationId = Application.Id.base
        minSdk = Application.Sdk.min
        targetSdk = Application.Sdk.target
        proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        multiDexEnabled = true
        vectorDrawables { useSupportLibrary = true }

        buildConfigField("String", "BASE_URL", baseUrl)
        buildConfigField("String", "USER_NAME", userNamed)
        buildConfigField("String", "PASSWORD", pass)
        buildConfigField("String", "INGREDIENT_THUMB_IMG_URL", ingThumbUrl)
        buildConfigField("String", "INGREDIENT_FULL_IMG_URL", ingFullThumbUrl)
        buildConfigField("String", "COCK_THUMB_IMG_URL", cockThumbUrl)
    }
    packagingOptions {

        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
        exclude("META-INF/*.kotlin_module")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.1"
    }
}

dependencies {

    implementation(fileTree("dir" to "libs", "include" to "*.jar"))

    // Compose
    implementation(Dependency.Compose.composeViewMdel)
    implementation(Dependency.Compose.composeNavigation)
    implementation(Dependency.Compose.composeFlowLayout)
    implementation(Dependency.Compose.composeUI)
    implementation(Dependency.Compose.composeMaterial)
    implementation(Dependency.Compose.composeAnimation)
    implementation(Dependency.Compose.composePreview)
    implementation(Dependency.Compose.composeActivity)
    implementation(Dependency.Compose.composeTooling)
    implementation(Dependency.Compose.composeIcons)
    // Coroutines
    implementation(Dependency.Coroutines.coroutinesCore)
    implementation(Dependency.Coroutines.coroutinesAndroid)
    // Hilt
    implementation(Dependency.Hilt.hiltAndroid)
    kapt(Dependency.Hilt.hiltAndroidCompiler)
    implementation(Dependency.Hilt.hiltViewMOdel)
    kapt(Dependency.Hilt.hiltCompiler)
    implementation(Dependency.Hilt.hiltNavigationCompose)

    // Lifecycle Components
    kapt(Dependency.LifecycleComponents.lifecycle_compiler)
    implementation(Dependency.LifecycleComponents.lifecycle_runtime)
    implementation(Dependency.LifecycleComponents.lifecycle_livedata)
    implementation(Dependency.LifecycleComponents.lifecycle_viewModel)

    //  Navigation
    implementation(navigation_fragment)
    implementation(navigation_ktx)
    implementation(navigation_runtime)

    // Room
    kapt(navigation_ktx)
    implementation(navigation_fragment)
    implementation(navigation_runtime)

    // AndroidX
    implementation(cardView)
    implementation(recyclerView)
    implementation(fragment)
    implementation(material)
    implementation(multidex)
    implementation(constraintLayout)

    implementation(Dependency.timber)
    implementation(Dependency.logger)
    implementation(picasso)

    // Stetho
    implementation(Dependency.Stetho.runtime)
    implementation(Dependency.Stetho.okhttp3)

    // Networking
    implementation(Dependency.Retrofit.runtime) {
        // exclude Retrofit’s OkHttp peer-dependency module and define your own module import
        exclude(module = "okhttp")
    }
    implementation(converterGson)
    implementation(http_runtime)
    implementation(http_logger)
    implementation(http_urlConnection)

    kapt(Dependency.Room.room_compiler)
    implementation(Dependency.Room.room_runtime)
    implementation(Dependency.Room.room_rxjava)
    implementation(Dependency.Room.room_ktx)
    // Coil
    implementation(Dependency.coil)
}
