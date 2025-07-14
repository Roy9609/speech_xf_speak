plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}


extra.set("GROUP", "com.clife.speak")
extra.set("MODULENAME", "XfSpeakSdk")
extra.set("MODULEVERSION", "1.0.0")

android {
    namespace = "com.roy.xfspeak"
    compileSdk = 33

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }


    android.libraryVariants.all { variant ->
        variant.outputs.all { output ->
            val baseName = "${extra["MODULENAME"]}-${extra["MODULEVERSION"]}"
            val outputFile = output.outputFile
            outputFile.renameTo(File(outputFile.parent, "xf_${baseName}.aar"))
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    android {
        sourceSets {
            getByName("main") {
                jniLibs.srcDirs("libs")
            }
        }
    }

}



dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    api(files("libs/SparkChain.aar"))
}

apply {
    from("../publish.gradle")
}