@Suppress("SpellCheckingInspection")
object Dependency {
    object AndroidX {
        const val cardView = "androidx.cardview:cardview:1.0.0"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
        const val fragment = "androidx.fragment:fragment-ktx:1.2.5"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.0-rc1"

        const val multidex = "androidx.multidex:multidex:2.0.1"
    }

    object Compose {
        const val composeViewMdel = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
        const val composeNavigation = "androidx.navigation:navigation-compose:2.4.0-rc01"
        const val composeFlowLayout = "com.google.accompanist:accompanist-flowlayout:0.17.0"
        const val composeUI = "androidx.compose.ui:ui:1.0.5"
        const val composeMaterial = "androidx.compose.material:material:1.0.5"
        const val composeAnimation = "androidx.compose.animation:animation:1.0.5"
        const val composePreview = "androidx.compose.ui:ui-tooling-preview:1.0.5"
        const val composeActivity = "androidx.activity:activity-compose:1.3.1"
        const val composeTooling = "androidx.compose.ui:ui-tooling:1.0.5"
        const val composeIcons = "androidx.compose.material:material-icons-extended:1.0.5"
    }

    object Coroutines {
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1"
    }

    object LifecycleComponents {
        private const val version = "2.3.1"
        const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime:$version"
        const val lifecycle_compiler = "androidx.lifecycle:lifecycle-compiler:$version"
        const val lifecycle_livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
        const val lifecycle_viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
    }

    object Navigation {
        private const val version = "2.3.5"
        const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:$version"
        const val navigation_ktx = "androidx.navigation:navigation-ui-ktx:$version"
        const val navigation_runtime = "androidx.navigation:navigation-runtime:$version"
    }

    object Room {
        private const val version = "2.3.0"
        const val room_runtime = "androidx.room:room-runtime:$version"
        const val room_compiler = "androidx.room:room-compiler:$version"
        const val room_rxjava = "androidx.room:room-rxjava2:$version"

        // Kotlin Extensions and Coroutines support for Room
        const val room_ktx = "androidx.room:room-ktx:$version"
    }

    object Hilt {
        const val hiltAndroid = "com.google.dagger:hilt-android:2.38.1"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:2.37"
        const val hiltViewMOdel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0"
        const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha03"
    }

    object Google {
        const val location = "com.google.android.gms:play-services-location:17.0.0"
        const val maps = "com.google.android.gms:play-services-maps:17.0.0"
        const val material = "com.google.android.material:material:1.2.0"
        const val tapAndPay = "com.google.android.gms:play-services-tapandpay:16.0.2"

        object Firebase {
            const val barcodeModel = "com.google.firebase:firebase-ml-vision-barcode-model:16.1.2"
            const val core = "com.google.firebase:firebase-core:17.5.0"
            const val messaging = "com.google.firebase:firebase-messaging:20.2.4"
            const val vision = "com.google.firebase:firebase-ml-vision:24.1.0"
        }
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
        const val test = "org.jetbrains.kotlin:kotlin-test"
        const val testJUnit = "org.jetbrains.kotlin:kotlin-test-junit"
    }

    const val libPhoneNumber = "com.googlecode.libphonenumber:libphonenumber:8.12.8"
    const val materialDialogs = "com.afollestad.material-dialogs:core:3.3.0"

    object OkHttp {
        private const val version = "5.0.0-alpha.2"
        const val http_runtime = "com.squareup.okhttp3:okhttp:$version"
        const val http_logger = "com.squareup.okhttp3:logging-interceptor:$version"
        const val http_urlConnection = "com.squareup.okhttp3:okhttp-urlconnection:$version"
    }

    const val picasso = "com.squareup.picasso:picasso:2.71828"

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
        const val runtime = "com.squareup.retrofit2:retrofit:$version"
    }

    object Stetho {
        private const val version = "1.5.1"
        const val runtime = "com.facebook.stetho:stetho:$version"
        const val okhttp3 = "com.facebook.stetho:stetho-okhttp3:$version"
    }

    const val timber = "com.jakewharton.timber:timber:5.0.1"
    const val logger = "com.orhanobut:logger:2.2.0"
    const val coil = "io.coil-kt:coil-compose:1.4.0"
}